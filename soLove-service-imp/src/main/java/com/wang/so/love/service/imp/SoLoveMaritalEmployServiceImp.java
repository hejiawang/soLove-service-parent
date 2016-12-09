package com.wang.so.love.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.model.SoLoveMaritalEmployModel;
import com.wang.so.love.service.param.SoLoveMaritalEmployParam;
import com.wang.so.love.service.service.SoLoveMaritalEmployService;
import com.wang.so.love.service.vo.SoLoveMaritalEmployVO;

/**
 * 婚介所工作人员信息接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
@Service
public class SoLoveMaritalEmployServiceImp implements SoLoveMaritalEmployService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveMaritalEmployServiceImp.class);
	
	/**
	 * SoLoveMaritalEmployModel
	 */
	@Autowired
	private SoLoveMaritalEmployModel soLoveMaritalEmployModel;
	
	/**
	 * 新增婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	@Override
	public ServiceResult<Void> addMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy) {
		Assert.notNull(soLoveMaritalEmployModel, "Property 'soLoveMaritalEmployModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMaritalEmployModel.addMaritalEmploy(maritalEmploy);
			if( isSuccess ){
				serviceResult.setMessage("新增婚介工作人员所成功");
			} else {
				serviceResult.setMessage("新增婚介工作人员所失败");
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
	 * 修改婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	@Override
	public ServiceResult<Void> updateMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy) {
		Assert.notNull(soLoveMaritalEmployModel, "Property 'soLoveMaritalEmployModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMaritalEmployModel.updateMaritalEmploy(maritalEmploy);
			if( isSuccess ){
				serviceResult.setMessage("修改婚介工作人员所成功");
			} else {
				serviceResult.setMessage("修改婚介工作人员所失败");
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
	 * 删除婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	@Override
	public ServiceResult<Void> deleteMaritalEmploy(Integer maritalEmployID) {
		Assert.notNull(soLoveMaritalEmployModel, "Property 'soLoveMaritalEmployModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMaritalEmployModel.deleteMaritalEmploy(maritalEmployID);
			if( isSuccess ){
				serviceResult.setMessage("删除婚介工作人员所成功");
			} else {
				serviceResult.setMessage("删除婚介工作人员所失败");
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
	 * 查看婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 婚介所工作人员以及所在婚介所的信息
	 */
	@Override
	public ServiceResult<SoLoveMaritalEmployVO> getMaritalEmploy(Integer maritalEmployID) {
		Assert.notNull(soLoveMaritalEmployModel, "Property 'soLoveMaritalEmployModel' is required.");
		ServiceResult<SoLoveMaritalEmployVO> serviceResult = new ServiceResult<SoLoveMaritalEmployVO>();
		try {
			SoLoveMaritalEmployVO maritalEmploy = soLoveMaritalEmployModel.getMaritalEmploy(maritalEmployID);
			serviceResult.setResult(maritalEmploy);
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
