package com.wang.so.love.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.model.SoLoveLoginModel;
import com.wang.so.love.service.param.SoLoveUserInfoParam;
import com.wang.so.love.service.service.SoLoveLoginService;

/**
 * 登录注册接口 imp
 * 
 * @author HeJiawang
 * @date   2016.12.02
 */
@Service
public class SoLoveLoginServiceImp implements SoLoveLoginService {
	
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveLoginServiceImp.class);
	
	/**
	 * soLoveLoginModel
	 */
	@Autowired
	private SoLoveLoginModel soLoveLoginModel;
	
	/**
	 * 登录
	 * 
	 * @param loginName 手机号
	 * @param password 密码
	 * @return userInfo
	 * @author HeJiawang
	 * @date   2016.12.02
	 */
	@Override
	public ServiceResult<SoLoveUserInfoParam> doLogin(String loginName, String passWord) {
		Assert.notNull(soLoveLoginModel, "Property 'soLoveLoginModel' is required.");
		ServiceResult<SoLoveUserInfoParam> serviceResult = new ServiceResult<>();
		try {
			SoLoveUserInfoParam userInfo = soLoveLoginModel.doLogin(loginName, passWord);
			if( userInfo == null ){
				serviceResult.setSuccess(false);
			} else {
				serviceResult.setResult(userInfo);
			}
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
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
	@Override
	public ServiceResult<SoLoveUserInfoParam> register(String loginName, String passWord) {
		Assert.notNull(soLoveLoginModel, "Property 'soLoveLoginModel' is required.");
		ServiceResult<SoLoveUserInfoParam> serviceResult = new ServiceResult<>();
		try {
			SoLoveUserInfoParam userInfo = soLoveLoginModel.register(loginName, passWord);
			serviceResult.setResult(userInfo);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 *  修改密码
	 * 
	 * @param 	userID 用户ID
	 * @param 	passWord 密码
	 * @author	HeJiawang
	 * @date	2016.12.07
	 */
	@Override
	public ServiceResult<Void> passWordEdit(Integer userID, String passWord) {
		Assert.notNull(soLoveLoginModel, "Property 'soLoveLoginModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean isSuccess = soLoveLoginModel.passWordEdit(userID, passWord);
			if( isSuccess ){
				serviceResult.setMessage("修改成功");
			} else {
				serviceResult.setMessage("修改失败");
			}
			serviceResult.setSuccess(isSuccess);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

}
