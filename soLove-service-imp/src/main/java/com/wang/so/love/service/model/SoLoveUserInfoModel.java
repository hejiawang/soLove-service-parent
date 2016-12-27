package com.wang.so.love.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.wang.so.love.service.dao.read.SoLoveChildrenInfoReadDao;
import com.wang.so.love.service.dao.read.SoLoveHobbyReadDao;
import com.wang.so.love.service.dao.read.SoLoveMateInfoReadDao;
import com.wang.so.love.service.dao.read.SoLoveParentInfoReadDao;
import com.wang.so.love.service.dao.read.SoLoveUserDetailInfoReadDao;
import com.wang.so.love.service.dao.read.SoLoveUserInfoImgReadDao;
import com.wang.so.love.service.dao.read.SoLoveUserInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveMateInfoWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserDetailInfoWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoImgWriteDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoWriteDao;
import com.wang.so.love.service.entity.SoLoveChildrenInfoEntity;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.entity.SoLoveMateInfoEntity;
import com.wang.so.love.service.entity.SoLoveParentInfoEntity;
import com.wang.so.love.service.entity.SoLoveUserDetailInfoEntity;
import com.wang.so.love.service.entity.SoLoveUserInfoEntity;
import com.wang.so.love.service.entity.SoLoveUserInfoImgEntity;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;
import com.wang.so.love.service.param.SoLoveUserInfoParam;
import com.wang.so.love.service.vo.SoLoveUserSimpleInfoVO;

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
	 * 用户详细信息——读
	 */
	@Autowired
	private SoLoveUserDetailInfoReadDao soLoveUserDetailInfoReadDao;
	
	/**
	 * 用户照片信息——写
	 */
	@Autowired
	private SoLoveUserInfoImgWriteDao soLoveUserInfoImgWriteDao;
	
	/**
	 * 用户照片信息——读
	 */
	@Autowired
	private SoLoveUserInfoImgReadDao soLoveUserInfoImgReadDao;
	
	/**
	 * 用户择偶信息——写
	 */
	@Autowired
	private SoLoveMateInfoWriteDao soLoveMateInfoWriteDao;
	
	/**
	 * 用户择偶信息——读
	 */
	@Autowired
	private SoLoveMateInfoReadDao soLoveMateInfoReadDao;
	
	/**
	 * 兴趣爱好——读
	 */
	@Autowired
	private SoLoveHobbyReadDao soLoveHobbyReadDao;
	
	/**
	 * 用户子女信息——读
	 */
	@Autowired
	private SoLoveChildrenInfoReadDao soLoveChildrenInfoReadDao;
	
	/**
	 * 用户父母信息——读
	 */
	@Autowired
	private SoLoveParentInfoReadDao soLoveParentInfoReadDao;
	
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
			String passWordMD5 = MD5.getInstrance().getMD5String4(userInfo.getPassWord());
			userInfo.setPassWord(passWordMD5);
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
			
			transactionManagerMember.commit(status);
			
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

	/**
	 * 删除用户
	 * 
	 * @param userID 用户ID
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	public Boolean deleteUserInfo(Integer userID) {
		Assert.notNull(soLoveUserInfoWriteDao, "Property 'soLoveUserInfoWriteDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		Integer result = soLoveUserInfoWriteDao.deleteUserInfo(userID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据用户ID查看用户的信息——详细信息、照片、爱好、子女父母等所有信息 
	 * 
	 * @param userID 用户ID
	 * 
	 * @return 
	 * 		用户信息Map</br>
	 * 		<li>key:userInfo——用户基本信息</li>
	 * 		<li>key:userDetail——用户详细信息</li>
	 * 		<li>key:userImg——用户照片信息</li>
	 * 		<li>key:userHobby——用户兴趣爱好信息</li>
	 * 		<li>key:userParent——用户父母信息</li>
	 * 		<li>key:userChildren——用户子女信息</li>
	 * 		<li>key:userMate——用户择偶信息</li>
	 * 
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	public Map<String, Object> viewUserInfo(Integer userID) {
		Assert.notNull(soLoveUserInfoReadDao, "Property 'soLoveUserInfoReadDao' is required.");
		Assert.notNull(soLoveUserDetailInfoReadDao, "Property 'soLoveUserDetailInfoReadDao' is required.");
		Assert.notNull(soLoveUserInfoImgReadDao, "Property 'soLoveUserInfoImgReadDao' is required.");
		Assert.notNull(soLoveMateInfoReadDao, "Property 'soLoveMateInfoReadDao' is required.");
		Assert.notNull(soLoveChildrenInfoReadDao, "Property 'soLoveChildrenInfoReadDao' is required.");
		Assert.notNull(soLoveParentInfoReadDao, "Property 'soLoveParentInfoReadDao' is required.");
		Assert.notNull(soLoveHobbyReadDao, "Property 'soLoveHobbyReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		SoLoveUserInfoEntity userInfo = soLoveUserInfoReadDao.getUserInfoByID(userID);
		SoLoveUserDetailInfoEntity userDetail = soLoveUserDetailInfoReadDao.getUserDetailInfoByUserID(userID);
		SoLoveUserInfoImgEntity userImg = soLoveUserInfoImgReadDao.getUserInfoImgByUserID(userID);
		SoLoveMateInfoEntity userMate = soLoveMateInfoReadDao.getMateInfoByUserID(userID);
		List<SoLoveParentInfoEntity> userParent = soLoveParentInfoReadDao.getParentInfoByUserID(userID);
		List<SoLoveChildrenInfoEntity> userChildren = soLoveChildrenInfoReadDao.getChildrenInfoByUserID(userID);
		List<SoLoveHobbyEntity> userHobby = soLoveHobbyReadDao.getHobbyByUserID(userID);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("userInfo", userInfo);
		result.put("userDetail", userDetail);
		result.put("userImg", userImg);
		result.put("userMate", userMate);
		result.put("userParent", userParent);
		result.put("userChildren", userChildren);
		result.put("userHobby", userHobby);
		
		return result;
	}
	
	/**
	 * 根据择偶条件筛选信息</br>
	 * 并进行分页
	 * 
	 * @param mateInfo 择偶信息
	 * @return 简单的用户信息,如：年龄、兴趣爱好等
	 * 
	 * @author HeJiawang
	 * @date   2016.12.07
	 */
	public List<SoLoveUserSimpleInfoVO> getUserByMateInfo(SoLoveMateInfoParam mateInfo) {
		Assert.notNull(soLoveUserInfoReadDao, "Property 'soLoveUserInfoReadDao' is required.");
		
		return soLoveUserInfoReadDao.getUserByMateInfo(mateInfo);
	}

	/**
	 * 根据条件搜索用户信息</br>
	 * 并进行分页
	 * 
	 * @param param 检索条件
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * 
	 * @return 适应So love后台管理系统js分页插件的Map
	 * 
	 * @author HeJiawang
	 * @date   2016.12.08
	 */
	public Map<String, Object> pageUserInfo(SoLoveUserDetailInfoParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveUserInfoReadDao, "Property 'soLoveUserInfoReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");;
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "userDetail", param );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = soLoveUserInfoReadDao.pageUserInfo(paramMap);
		Integer recordsTotal = soLoveUserInfoReadDao.pageUserInfoTotal(param);
		
		/**
		 * 将结果按前台js分页插件的要求装进map
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("draw", draw);
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 修改用户基本信息
	 * 
	 * @param userInfo 用户基本信息参数
	 * 
	 * @author HeJiawang
	 * @date   2016.12.27
	 */
	public Boolean updateUserInfo(SoLoveUserInfoParam userInfo) {
		Assert.notNull(soLoveUserInfoWriteDao, "Property 'soLoveUserInfoWriteDao' is required.");
		if( userInfo.getUserID() == null ) throw new BusinessException("用户ID不能为空");
		
		Integer result = soLoveUserInfoWriteDao.updateUserInfo(userInfo);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

}
