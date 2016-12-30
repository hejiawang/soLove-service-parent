package com.wang.so.love.service.imp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.entity.SoLoveMaritalAgencyEntity;
import com.wang.so.love.service.model.SoLoveMaritalAgencyModel;
import com.wang.so.love.service.param.SoLoveMaritalAgencyParam;
import com.wang.so.love.service.service.SoLoveMaritalAgencyService;

/**
 * 婚介所信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
@Service
public class SoLoveMaritalAgencyServiceImp implements SoLoveMaritalAgencyService {
	
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveUserInfoServiceImp.class);
	
	/**
	 * soLoveMaritalAgencyModel
	 */
	@Autowired
	private SoLoveMaritalAgencyModel soLoveMaritalAgencyModel;
	
	/**
	 * 新增婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 */
	@Override
	public ServiceResult<Void> addMaritalAgency(SoLoveMaritalAgencyParam maritalAgency) {
		Assert.notNull(soLoveMaritalAgencyModel, "Property 'soLoveMaritalAgencyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMaritalAgencyModel.addMaritalAgency(maritalAgency);
			if( isSuccess ){
				serviceResult.setMessage("新增婚介所成功");
			} else {
				serviceResult.setMessage("新增婚介所失败");
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
	 * 修改婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 */
	@Override
	public ServiceResult<Void> updateMaritalAgency(SoLoveMaritalAgencyParam maritalAgency) {
		Assert.notNull(soLoveMaritalAgencyModel, "Property 'soLoveMaritalAgencyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMaritalAgencyModel.updateMaritalAgency(maritalAgency);
			if( isSuccess ){
				serviceResult.setMessage("修改婚介所成功");
			} else {
				serviceResult.setMessage("修改婚介所失败");
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
	 * 删除婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 */
	@Override
	public ServiceResult<Void> deleteMaritalAgency(Integer maritalAgencyID) {
		Assert.notNull(soLoveMaritalAgencyModel, "Property 'soLoveMaritalAgencyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMaritalAgencyModel.deleteMaritalAgency(maritalAgencyID);
			if( isSuccess ){
				serviceResult.setMessage("删除婚介所成功");
			} else {
				serviceResult.setMessage("删除婚介所失败");
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
	 * 获取婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 * @return 婚介所信息
	 */
	@Override
	public ServiceResult<SoLoveMaritalAgencyEntity> getMaritalAgencyByID(Integer maritalAgencyID) {
		Assert.notNull(soLoveMaritalAgencyModel, "Property 'soLoveMaritalAgencyModel' is required.");
		ServiceResult<SoLoveMaritalAgencyEntity> serviceResult = new ServiceResult<SoLoveMaritalAgencyEntity>();
		try {
			SoLoveMaritalAgencyEntity MaritalAgency = soLoveMaritalAgencyModel.getMaritalAgencyByID(maritalAgencyID);
			serviceResult.setResult(MaritalAgency);
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
	 * 分页获取婚介所信息
	 * 
	 * @param param 查询信息
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.30
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageMaritalAgency(SoLoveMaritalAgencyParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveMaritalAgencyModel, "Property 'soLoveMaritalAgencyModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveMaritalAgencyModel.pageMaritalAgency(param, start, length, draw);
			serviceResult.setResult(resultMap);
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
