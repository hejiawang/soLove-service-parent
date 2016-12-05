package com.wang.so.love.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.entity.SoLoveMateInfoEntity;
import com.wang.so.love.service.model.SoLoveMateInfoModel;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.service.SoLoveMateInfoService;

/**
 * 用户择偶信息接口实现
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@Service
public class SoLoveMateInfoServiceImp implements SoLoveMateInfoService {
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveMateInfoServiceImp.class);

	/**
	 * soLoveMateInfoModel
	 */
	private SoLoveMateInfoModel soLoveMateInfoModel;

	/**
	 * 修改(完善)用户择偶信息
	 * 
	 * @param mateInfo 用户择偶信息
	 */
	@Override
	public ServiceResult<Void> updateMateInfo(SoLoveMateInfoParam mateInfo) {
		Assert.notNull(soLoveMateInfoModel, "Property 'soLoveMateInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMateInfoModel.updateMateInfo(mateInfo);
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
	 * 根据用户ID获取该用户的择偶信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	@Override
	public ServiceResult<SoLoveMateInfoEntity> getMateInfoByID(Integer userID) {
		Assert.notNull(soLoveMateInfoModel, "Property 'soLoveMateInfoModel' is required.");
		ServiceResult<SoLoveMateInfoEntity> serviceResult = new ServiceResult<SoLoveMateInfoEntity>();
		try {
			SoLoveMateInfoEntity mateInfo = soLoveMateInfoModel.getMateInfoByID(userID);
			serviceResult.setResult(mateInfo);
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
