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
import com.wang.so.love.service.dao.read.SoLoveUserInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveMateInfoWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserDetailInfoWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoImgWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoWriteDao;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 用户基本信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveUserInfoModel {

	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * soLoveUserInfoReadDao
	 */
	@Autowired
	private SoLoveUserInfoReadDao soLoveUserInfoReadDao;
	
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
	 * 新增一个普通注册用户</br>
	 * 记录登录手机号、密码、注册方式的信息</br>
	 * 并在详细信息表、照片表、择偶信息表中新建一条与该用户对应的数据</br>
	 * 若要填写详细信息,应进行信息维护</br>
	 * 
	 * 注意:本方法用户后台添加用户,app注册应调用SoLoveLoginService
	 * 
	 * @param userInfo 用户信息
	 * @return 是否新增成功
	 */
	public Boolean addUserInfo(SoLoveUserInfoParam userInfo) {
		Assert.notNull(soLoveUserInfoWriteDao, "Property 'soLoveUserInfoWriteDao' is required.");
		Assert.notNull(soLoveUserDetailInfoWriteDao, "Property 'soLoveUserDetailInfoWriteDao' is required.");
		Assert.notNull(soLoveUserInfoImgWriteDao, "Property 'soLoveUserInfoImgWriteDao' is required.");
		Assert.notNull(soLoveMateInfoWriteDao, "Property 'soLoveMateInfoWriteDao' is required.");
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		if( StringUtils.isBlank(userInfo.getLoginName()) ) throw new BusinessException("用户LoginName不能为空");
		if( StringUtils.isBlank(userInfo.getPassWord()) ) throw new BusinessException("用户密码不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			
			/**
			 * 插入基本信息</br>
			 * 在实体中返回userID
			 */
			Integer result = soLoveUserInfoWriteDao.insertUserInfo(userInfo);
			Integer userID = userInfo.getUserID();
			
			/**
			 * 插入一条只有用户ID的用户详情信息
			 */
			SoLoveUserDetailInfoParam userDetailInfo = new SoLoveUserDetailInfoParam();
			userDetailInfo.setUserID(userID);
			result = soLoveUserDetailInfoWriteDao.insertUserDetailInfo(userDetailInfo);
			
			/**
			 * 插入一条只有用户ID的用户照片信息
			 */
			SoLoveUserInfoImgParam userInfoImg = new SoLoveUserInfoImgParam();
			userInfoImg.setUserID(userID);
			result = soLoveUserInfoImgWriteDao.insertUserInfoImg(userInfoImg);
			
			/**
			 * 插入一条只有用户ID的择偶信息
			 */
			SoLoveMateInfoParam mateInfo = new SoLoveMateInfoParam();
			mateInfo.setUserID(userID);
			result = soLoveMateInfoWriteDao.insertMateInfo(mateInfo);
			
			if( result >= 1 ){
				return true;
			} else {
				return false;
			}
		} catch ( Exception e ){
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增用户失败!");
		}
	}

	/**
	 * 检查用户信息合法性</br>
	 * 1、loginName不能重复
	 * 
	 * @param userInfo 用户信息
	 * @return 检查通过为true，未通过为false
	 */
	public Boolean checkUserInfo(SoLoveUserInfoParam userInfo) {
		Assert.notNull(soLoveUserInfoReadDao, "Property 'soLoveUserInfoReadDao' is required.");
		if( StringUtils.isBlank(userInfo.getLoginName()) ) throw new BusinessException("用户LoginName不能为空");
		
		Integer result = soLoveUserInfoReadDao.checkLoginName(userInfo);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

}
