package com.wang.so.love.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.model.SoLoveHobbyModel;
import com.wang.so.love.service.param.SoLoveHobbyParam;
import com.wang.so.love.service.service.SoLoveHobbyService;

/**
 * 兴趣爱好接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveHobbyServiceImp implements SoLoveHobbyService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveHobbyServiceImp.class);
	
	/**
	 * soLoveHobbyModel
	 */
	@Autowired
	private SoLoveHobbyModel soLoveHobbyModel;
	
	/**
	 * 新增兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 */
	@Override
	public ServiceResult<Void> addHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.addHobby(hobby);
			if( isSuccess ){
				serviceResult.setMessage("新增信息成功");
			} else {
				serviceResult.setMessage("新增信息失败");
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

	/**
	 * 修改兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 */
	@Override
	public ServiceResult<Void> modifyHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.modifyHobby(hobby);
			if( isSuccess ){
				serviceResult.setMessage("修改信息成功");
			} else {
				serviceResult.setMessage("修改信息失败");
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
	
	/**
	 * 删除兴趣爱好
	 * 
	 * @param hobbyID 兴趣爱好ID
	 */
	@Override
	public ServiceResult<Void> deleteHobby(Integer hobbyID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.deleteHobby(hobbyID);
			if( isSuccess ){
				serviceResult.setMessage("删除信息成功");
			} else {
				serviceResult.setMessage("删除信息失败");
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
	
	/**
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 */
	@Override
	public ServiceResult<SoLoveHobbyEntity> getHobbyByID(Integer hobbyID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<SoLoveHobbyEntity> serviceResult = new ServiceResult<SoLoveHobbyEntity>();
		try {
			SoLoveHobbyEntity hobby = soLoveHobbyModel.getHobbyByID(hobbyID);
			serviceResult.setResult(hobby);
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
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 */
	@Override
	public ServiceResult<List<SoLoveHobbyEntity>> getHobbyByUserID(Integer userID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<List<SoLoveHobbyEntity>> serviceResult = new ServiceResult<List<SoLoveHobbyEntity>>();
		try {
			List<SoLoveHobbyEntity> hobbyList = soLoveHobbyModel.getHobbyByUserID(userID);
			serviceResult.setResult(hobbyList);
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
