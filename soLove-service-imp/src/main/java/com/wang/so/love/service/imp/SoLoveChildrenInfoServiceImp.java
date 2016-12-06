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
import com.wang.so.love.service.entity.SoLoveChildrenInfoEntity;
import com.wang.so.love.service.model.SoLoveChildrenInfoModel;
import com.wang.so.love.service.param.SoLoveChildrenInfoParam;
import com.wang.so.love.service.service.SoLoveChildrenInfoService;

/**
 * 用户子女信息接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveChildrenInfoServiceImp implements SoLoveChildrenInfoService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveChildrenInfoServiceImp.class);
	
	/**
	 * soLoveChildrenInfoModel
	 */
	@Autowired
	private SoLoveChildrenInfoModel soLoveChildrenInfoModel;
	
	/**
	 * 新增用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 * @return ServiceResult
	 */
	@Override
	public ServiceResult<Void> addChildrenInfo(SoLoveChildrenInfoParam childrenInfo) {
		Assert.notNull(soLoveChildrenInfoModel, "Property 'soLoveChildrenInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		
		try {
			Boolean isSuccess = soLoveChildrenInfoModel.addChildrenInfo(childrenInfo);
			if( isSuccess ){
				serviceResult.setMessage("新增成功");
			} else {
				serviceResult.setMessage("新增失败");
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
	 * 修改用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 * @return ServiceResult
	 */
	@Override
	public ServiceResult<Void> updateChildrenInfo(SoLoveChildrenInfoParam childrenInfo) {
		Assert.notNull(soLoveChildrenInfoModel, "Property 'soLoveChildrenInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		
		try {
			Boolean isSuccess = soLoveChildrenInfoModel.updateChildrenInfo(childrenInfo);
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

	/**
	 * 根据子女信息ID删除用户子女信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return ServiceResult
	 */
	@Override
	public ServiceResult<Void> deleteChildrenInfo(Integer childrenID) {
		Assert.notNull(soLoveChildrenInfoModel, "Property 'soLoveChildrenInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		
		try {
			Boolean isSuccess = soLoveChildrenInfoModel.deleteChildrenInfo(childrenID);
			if( isSuccess ){
				serviceResult.setMessage("删除成功");
			} else {
				serviceResult.setMessage("删除失败");
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
	 * 根据子女信息ID获取用户子女详细信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return 用户子女信息
	 */
	@Override
	public ServiceResult<SoLoveChildrenInfoEntity> getChildrenInfoByID(Integer childrenID) {
		Assert.notNull(soLoveChildrenInfoModel, "Property 'soLoveChildrenInfoModel' is required.");
		ServiceResult<SoLoveChildrenInfoEntity> serviceResult = new ServiceResult<SoLoveChildrenInfoEntity>();
		
		try {
			SoLoveChildrenInfoEntity childrenInfo = soLoveChildrenInfoModel.getChildrenInfoByID(childrenID);
			serviceResult.setResult(childrenInfo);
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
	 * 根据用户ID获取该用户的所有子女
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有子女信息
	 */
	@Override
	public ServiceResult<List<SoLoveChildrenInfoEntity>> getChildrenInfoByUserID(Integer userID) {
		Assert.notNull(soLoveChildrenInfoModel, "Property 'soLoveChildrenInfoModel' is required.");
		ServiceResult<List<SoLoveChildrenInfoEntity>> serviceResult = new ServiceResult<List<SoLoveChildrenInfoEntity>>();
		
		try {
			List<SoLoveChildrenInfoEntity> childrenInfoList = soLoveChildrenInfoModel.getChildrenInfoByUserID(userID);
			serviceResult.setResult(childrenInfoList);
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
