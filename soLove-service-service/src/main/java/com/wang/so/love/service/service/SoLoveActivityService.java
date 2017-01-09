package com.wang.so.love.service.service;

import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveActivityEntity;
import com.wang.so.love.service.param.SoLoveActivityParam;

/**
 * 活动service
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
public interface SoLoveActivityService {

	/**
	 * 分页获取活动信息
	 * @param activity 查询参数
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 */
	public ServiceResult<Map<String,Object>> pageActivity(SoLoveActivityParam activity, Integer start, Integer length, Integer draw);
	
	/**
	 * 新增一个活动
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	public ServiceResult<Void> addActivity(SoLoveActivityParam activity);
	
	/**
	 * 修改活动信息
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	public ServiceResult<Void> updateActivity(SoLoveActivityParam activity);
	
	/**
	 * 删除一个活动
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	public ServiceResult<Void> deleteActivity(Integer activityID);
	
	/**
	 * 根据活动ID获取活动信息
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	public ServiceResult<SoLoveActivityEntity> getActivityByID(Integer activityID);
}
