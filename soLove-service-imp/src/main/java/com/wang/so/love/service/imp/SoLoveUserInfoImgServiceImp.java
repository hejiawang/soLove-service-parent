package com.wang.so.love.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.entity.SoLoveUserInfoImgEntity;
import com.wang.so.love.service.model.SoLoveUserInfoImgModel;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;
import com.wang.so.love.service.service.SoLoveUserInfoImgService;

/**
 * 用户图片信息接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveUserInfoImgServiceImp implements SoLoveUserInfoImgService {
	
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveUserInfoImgServiceImp.class);
	
	/**
	 * soLoveUserInfoImgModel
	 */
	@Autowired
	private SoLoveUserInfoImgModel soLoveUserInfoImgModel;
	
	/**
	 * 更新用户照片
	 * 
	 * @param userInfoImg 用户照片信息
	 */
	@Override
	public ServiceResult<Void> updateUserInfoImg(SoLoveUserInfoImgParam userInfoImg) {
		Assert.notNull(soLoveUserInfoImgModel, "Property 'soLoveUserInfoImgModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveUserInfoImgModel.updateUserInfoImg(userInfoImg);
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
	 * 根据用户ID获取用户照片信息
	 * 
	 * @param userID 用户ID
	 * @return 用户照片信息
	 */
	@Override
	public ServiceResult<SoLoveUserInfoImgEntity> getUserInfoImgByUserID(Integer userID) {
		Assert.notNull(soLoveUserInfoImgModel, "Property 'soLoveUserInfoImgModel' is required.");
		ServiceResult<SoLoveUserInfoImgEntity> serviceResult = new ServiceResult<SoLoveUserInfoImgEntity>();
		try {
			SoLoveUserInfoImgEntity userInfoImg = soLoveUserInfoImgModel.getUserInfoImgByUserID(userID);
			serviceResult.setResult(userInfoImg);
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
