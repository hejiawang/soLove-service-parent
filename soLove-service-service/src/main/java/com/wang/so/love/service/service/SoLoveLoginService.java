package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 登录注册接口
 * 
 * @author HeJiawang
 * @date   2016.12.02
 */
public interface SoLoveLoginService {

	/**
	 * 登录
	 * 
	 * @param loginName 手机号
	 * @param password 密码
	 * @return userInfo
	 * @author HeJiawang
	 * @date   2016.12.02
	 */
	public ServiceResult<SoLoveUserInfoParam> doLogin(String loginName, String passWord);

	/**
	 * 注册
	 * 
	 * @param loginName 手机号
	 * @param passWord 密码
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.12.02
	 */
	public ServiceResult<SoLoveUserInfoParam> register(String loginName, String passWord);
}
