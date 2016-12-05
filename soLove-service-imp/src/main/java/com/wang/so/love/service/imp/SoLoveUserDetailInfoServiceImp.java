package com.wang.so.love.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.entity.SoLoveUserDetailInfoEntity;
import com.wang.so.love.service.model.SoLoveUserDetailInfoModel;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.service.SoLoveUserDetailInfoService;

/**
 * 用户详细信息接口实现
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@Service
public class SoLoveUserDetailInfoServiceImp implements SoLoveUserDetailInfoService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveUserDetailInfoServiceImp.class);
	
	/**
	 * soloveUserDetailInfoModel
	 */
	@Autowired
	private SoLoveUserDetailInfoModel soloveUserDetailInfoModel;
	
	/**
	 * 修改(完善)用户详细信息
	 * 
	 * @param userDetailInfo 用户详细信息
	 */
	@Override
	public ServiceResult<Void> updateUserDetailInfo(SoLoveUserDetailInfoParam userDetailInfo) {
		Assert.notNull(soloveUserDetailInfoModel, "Property 'soloveUserDetailInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soloveUserDetailInfoModel.updateUserDetailInfo(userDetailInfo);
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
	 * 根据用户ID获取该用户详细信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	@Override
	public ServiceResult<SoLoveUserDetailInfoEntity> getUserDetailInfoByID(Integer userID) {
		Assert.notNull(soloveUserDetailInfoModel, "Property 'soloveUserDetailInfoModel' is required.");
		ServiceResult<SoLoveUserDetailInfoEntity> serviceResult = new ServiceResult<SoLoveUserDetailInfoEntity>();
		try {
			SoLoveUserDetailInfoEntity userDetailInfo = soloveUserDetailInfoModel.getUserDetailInfoByID(userID);
			serviceResult.setResult(userDetailInfo);
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
