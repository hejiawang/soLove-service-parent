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
import com.wang.so.love.service.entity.SoLoveParentInfoEntity;
import com.wang.so.love.service.model.SoLoveParentInfoModel;
import com.wang.so.love.service.param.SoLoveParentInfoParam;
import com.wang.so.love.service.service.SoLoveParentInfoService;

/**
 * 用户父母信息接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveParentInfoServiceImp implements SoLoveParentInfoService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveParentInfoServiceImp.class);
	
	/**
	 * soLoveParentInfoModel
	 */
	@Autowired
	private SoLoveParentInfoModel soLoveParentInfoModel;
	
	/**
	 * 新增用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 * @return ServiceResult
	 */
	@Override
	public ServiceResult<Void> addParentInfo(SoLoveParentInfoParam parentInfo) {
		Assert.notNull(soLoveParentInfoModel, "Property 'soLoveParentInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		
		try {
			Boolean isSuccess = soLoveParentInfoModel.addParentInfo(parentInfo);
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
	 * 修改用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 * @return ServiceResult
	 */
	@Override
	public ServiceResult<Void> updateParentInfo(SoLoveParentInfoParam parentInfo) {
		Assert.notNull(soLoveParentInfoModel, "Property 'soLoveParentInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		
		try {
			Boolean isSuccess = soLoveParentInfoModel.updateParentInfo(parentInfo);
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
	 * 根据父母信息ID删除用户父母信息
	 * 
	 * @param parentID 用户父母信息ID
	 * @return ServiceResult
	 */
	@Override
	public ServiceResult<Void> deleteParentInfo(Integer parentID) {
		Assert.notNull(soLoveParentInfoModel, "Property 'soLoveParentInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		
		try {
			Boolean isSuccess = soLoveParentInfoModel.deleteParentInfo(parentID);
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
	 * 根据父母信息ID获取用户父母详细信息
	 * 
	 * @param parentID 用户父母信息ID
	 * @return 用户父母信息
	 */
	@Override
	public ServiceResult<SoLoveParentInfoEntity> getParentInfoByID(Integer parentID) {
		Assert.notNull(soLoveParentInfoModel, "Property 'soLoveParentInfoModel' is required.");
		ServiceResult<SoLoveParentInfoEntity> serviceResult = new ServiceResult<SoLoveParentInfoEntity>();
		
		try {
			SoLoveParentInfoEntity ParentInfo = soLoveParentInfoModel.getParentInfoByID(parentID);
			serviceResult.setResult(ParentInfo);
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
	 * 根据用户ID获取该用户的所有父母
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有父母信息
	 */
	@Override
	public ServiceResult<List<SoLoveParentInfoEntity>> getParentInfoByUserID(Integer userID) {
		Assert.notNull(soLoveParentInfoModel, "Property 'soLoveParentInfoModel' is required.");
		ServiceResult<List<SoLoveParentInfoEntity>> serviceResult = new ServiceResult<List<SoLoveParentInfoEntity>>();
		
		try {
			List<SoLoveParentInfoEntity> ParentInfoList = soLoveParentInfoModel.getParentInfoByUserID(userID);
			serviceResult.setResult(ParentInfoList);
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
