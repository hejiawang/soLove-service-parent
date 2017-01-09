package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveActivityParam;

/**
 * 活动——写
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@MyBatisRepository
public interface SoLoveActivityWriteDao {

	/**
	 * 新增一个活动
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	Integer addActivity(SoLoveActivityParam activity);

	/**
	 * 修改活动信息
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	Integer updateActivity(SoLoveActivityParam activity);

	/**
	 * 删除一个活动
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	Integer deleteActivity(@Param("activityID")Integer activityID);

}
