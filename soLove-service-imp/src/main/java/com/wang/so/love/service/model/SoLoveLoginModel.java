package com.wang.so.love.service.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.core.util.MD5;
import com.wang.so.love.service.dao.read.SoLoveLoginReadDao;
import com.wang.so.love.service.dao.write.SoLoveLoginWriteDao;
import com.wang.so.love.service.dao.write.SoLoveMateInfoWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserDetailInfoWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoImgWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoWriteDao;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 登录注册 Model
 * 
 * @author HeJiawang
 * @date   2016.12.02
 */
@Service
public class SoLoveLoginModel {

	/**
	 * soLoveLoginReadDao
	 */
	@Autowired
	private SoLoveLoginReadDao soLoveLoginReadDao;
	
	/**
	 * soLoveLoginWriteDao
	 */
	@Autowired
	private SoLoveLoginWriteDao soLoveLoginWriteDao;
	
	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * soLoveUserInfoWriteDao
	 */
	@Autowired
	private SoLoveUserInfoWriteDao soLoveUserInfoWriteDao;
	
	/**
	 * 用户详细信息——写
	 */
	@Autowired
	private SoLoveUserDetailInfoWriteDao soLoveUserDetailInfoWriteDao;
	
	/**
	 * 用户照片信息——写
	 */
	@Autowired
	private SoLoveUserInfoImgWriteDao soLoveUserInfoImgWriteDao;
	
	/**
	 * 用户择偶信息——写
	 */
	@Autowired
	private SoLoveMateInfoWriteDao soLoveMateInfoWriteDao;
	
	
	/**
	 * 登录
	 * 
	 * @param loginName 手机号
	 * @param passWord 登录名
	 * @return SoLoveUserInfoParam
	 * @author HeJiawang
	 * @date   2016.12.02 
	 */
	public SoLoveUserInfoParam doLogin(String loginName, String passWord) {
		Assert.notNull(soLoveLoginReadDao, "Property 'soLoveLoginReadDao' is required.");
		if (StringUtils.isBlank(loginName))  throw new BusinessException("手机号不能为空");
		if (StringUtils.isBlank(passWord))  throw new BusinessException("密码不能为空");
		
		passWord = MD5.getInstrance().getMD5String4(passWord);
		return soLoveLoginReadDao.getUserInfoByLoginNameAndPwd(loginName, passWord);
	}

	/**
	 * 注册
	 * 
	 * @param loginName 手机号
	 * @param passWord 密码
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.12.02
	 */
	public SoLoveUserInfoParam register(String loginName, String passWord) {
		Assert.notNull(soLoveLoginWriteDao, "Property 'soLoveLoginWriteDao' is required.");
		Assert.notNull(soLoveUserInfoWriteDao, "Property 'soLoveUserInfoWriteDao' is required.");
		Assert.notNull(soLoveUserDetailInfoWriteDao, "Property 'soLoveUserDetailInfoWriteDao' is required.");
		Assert.notNull(soLoveUserInfoImgWriteDao, "Property 'soLoveUserInfoImgWriteDao' is required.");
		Assert.notNull(soLoveMateInfoWriteDao, "Property 'soLoveMateInfoWriteDao' is required.");
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		if (StringUtils.isBlank(loginName))  throw new BusinessException("手机号不能为空");
		if (StringUtils.isBlank(passWord))  throw new BusinessException("密码不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			
			/**
			 * 插入基本信息</br>
			 * 在实体中返回userID
			 */
			SoLoveUserInfoParam userInfo = new SoLoveUserInfoParam();
			userInfo.setPassWord( MD5.getInstrance().getMD5String4(passWord) );
			userInfo.setLoginName(loginName);
			soLoveUserInfoWriteDao.insertUserInfo(userInfo);
			Integer userID = userInfo.getUserID();
			
			/**
			 * 插入一条只有用户ID的用户详情信息
			 */
			SoLoveUserDetailInfoParam userDetailInfo = new SoLoveUserDetailInfoParam();
			userDetailInfo.setUserID(userID);
			soLoveUserDetailInfoWriteDao.insertUserDetailInfo(userDetailInfo);
			
			/**
			 * 插入一条只有用户ID的用户照片信息
			 */
			SoLoveUserInfoImgParam userInfoImg = new SoLoveUserInfoImgParam();
			userInfoImg.setUserID(userID);
			soLoveUserInfoImgWriteDao.insertUserInfoImg(userInfoImg);
			
			/**
			 * 插入一条只有用户ID的择偶信息
			 */
			SoLoveMateInfoParam mateInfo = new SoLoveMateInfoParam();
			mateInfo.setUserID(userID);
			soLoveMateInfoWriteDao.insertMateInfo(mateInfo);
			
			return userInfo;
		} catch ( Exception e ){
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增用户失败!");
		}
	}

	/**
	 *  修改密码
	 * 
	 * @param 	userID 用户ID
	 * @param 	passWord 密码
	 * @return	是否成功
	 * @author	HeJiawang
	 * @date	2016.12.07
	 */
	public Boolean passWordEdit(Integer userID, String passWord) {
		Assert.notNull(soLoveLoginWriteDao, "Property 'soLoveLoginWriteDao' is required.");
		if ( userID == null )  throw new BusinessException("用户ID不能为空");
		if (StringUtils.isBlank(passWord))  throw new BusinessException("密码不能为空");
		
		Integer result = soLoveLoginWriteDao.updatePassWord(userID, passWord);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

}
