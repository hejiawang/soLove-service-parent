package com.wang.so.love.service.dao.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveActivityEntity;
import com.wang.so.love.service.param.SoLoveActivityParam;

/**
 * 活动——读
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@MyBatisRepository
public interface SoLoveActivityReadDao {

	/**
	 * 分页获取活动信息
	 * @param paramMap 分页查询条件
	 * @return
	 */
	List<Map<String, Object>> pageActivity(Map<String, Object> paramMap);

	/**
	 * 获取活动信息条数
	 * @param activity 分页查询条件
	 * @return
	 */
	Integer pageActivityTotal(SoLoveActivityParam activity);

	/**
	 * 检查活动是否在报名中
	 * 
	 * @param activityID 活动ID
	 * @return 小于等于0——验证通过，该活动没有在活动期限内
	 */
	Integer checkCurrent(@Param("activityID")Integer activityID);

	/**
	 * 根据活动ID获取活动信息
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	SoLoveActivityEntity getActivityByID(@Param("activityID")Integer activityID);

}
