package com.wang.so.love.service.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.core.util.MD5;
import com.wang.so.love.service.dao.read.SoLoveLoginReadDao;
import com.wang.so.love.service.dao.write.SoLoveLoginWriteDao;
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
		if (StringUtils.isBlank(loginName)) {
			throw new BusinessException("手机号不能为空");
		}
		if (StringUtils.isBlank(passWord)) {
			throw new BusinessException("密码不能为空");
		}
		
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
		if (StringUtils.isBlank(loginName)) {
			throw new BusinessException("手机号不能为空");
		}
		if (StringUtils.isBlank(passWord)) {
			throw new BusinessException("密码不能为空");
		}
		
		SoLoveUserInfoParam userInfo = new SoLoveUserInfoParam();
		userInfo.setPassWord( MD5.getInstrance().getMD5String4(passWord) );
		userInfo.setLoginName(loginName);
		
		soLoveLoginWriteDao.registerUserInfo(userInfo);
		
		// 
		return userInfo;
	}

}
