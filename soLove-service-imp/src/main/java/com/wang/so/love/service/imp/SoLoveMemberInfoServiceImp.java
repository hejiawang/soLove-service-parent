package com.wang.so.love.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.model.SoLoveMemberInfoModel;
import com.wang.so.love.service.param.SoLoveMemberInfoParam;
import com.wang.so.love.service.service.SoLoveMemberInfoService;

/**
 * 会员信息接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveMemberInfoServiceImp implements SoLoveMemberInfoService {
	
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveMemberInfoServiceImp.class);
	
	/**
	 * soLoveMemberInfoModel
	 */
	@Autowired
	private SoLoveMemberInfoModel soLoveMemberInfoModel;
	
	/**
	 * 为用户开通会员
	 * 
	 * @param memberInfo 会员信息
	 */
	@Override
	public ServiceResult<Void> openMemberForUser(SoLoveMemberInfoParam memberInfo) {
		Assert.notNull(soLoveMemberInfoModel, "Property 'soLoveMemberInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMemberInfoModel.openMemberForUser(memberInfo);
			if( isSuccess ){
				serviceResult.setMessage("开通会员成功");
			} else {
				serviceResult.setMessage("开通会员失败");
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
