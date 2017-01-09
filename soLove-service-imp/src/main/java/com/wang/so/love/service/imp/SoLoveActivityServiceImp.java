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
import com.wang.so.love.service.entity.SoLoveActivityEntity;
import com.wang.so.love.service.model.SoLoveActivityModel;
import com.wang.so.love.service.param.SoLoveActivityParam;
import com.wang.so.love.service.service.SoLoveActivityService;

/**
 * 活动 service Imp
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@Service
public class SoLoveActivityServiceImp implements SoLoveActivityService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveActivityServiceImp.class);
	
	/**
	 * soLoveActivityModel
	 */
	@Autowired
	private SoLoveActivityModel soLoveActivityModel;
	
	/**
	 * 分页获取活动信息
	 * @param activity 查询参数
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageActivity(SoLoveActivityParam activity, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveActivityModel, "Property 'soLoveActivityModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveActivityModel.pageActivity(activity, start, length, draw);
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

	/**
	 * 新增一个活动
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	@Override
	public ServiceResult<Void> addActivity(SoLoveActivityParam activity) {
		Assert.notNull(soLoveActivityModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveActivityModel.addActivity(activity);
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
	 * 修改活动信息
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	@Override
	public ServiceResult<Void> updateActivity(SoLoveActivityParam activity) {
		Assert.notNull(soLoveActivityModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveActivityModel.updateActivity(activity);
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
	 * 删除一个活动
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	@Override
	public ServiceResult<Void> deleteActivity(Integer activityID) {
		Assert.notNull(soLoveActivityModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean checkSuccess = soLoveActivityModel.checkCurrent(activityID);	//判断活动状态，活动进行中，不可删除
			if( !checkSuccess ){
				serviceResult.setMessage("活动中!不可删除");
				serviceResult.setSuccess(false);
			} else {
				Boolean isSuccess = soLoveActivityModel.deleteActivity(activityID);
				if( isSuccess ){
					serviceResult.setMessage("删除成功");
				} else {
					serviceResult.setMessage("删除失败");
				}
				serviceResult.setSuccess(isSuccess);
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
	 * 根据活动ID获取活动信息
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	@Override
	public ServiceResult<SoLoveActivityEntity> getActivityByID(Integer activityID) {
		Assert.notNull(soLoveActivityModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<SoLoveActivityEntity> serviceResult = new ServiceResult<SoLoveActivityEntity>();
		try {
			SoLoveActivityEntity activity = soLoveActivityModel.getActivityByID(activityID);
			serviceResult.setResult(activity);
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
