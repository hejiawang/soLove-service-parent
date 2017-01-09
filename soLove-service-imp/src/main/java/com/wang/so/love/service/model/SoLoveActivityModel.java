package com.wang.so.love.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveActivityReadDao;
import com.wang.so.love.service.dao.write.SoLoveActivityWriteDao;
import com.wang.so.love.service.entity.SoLoveActivityEntity;
import com.wang.so.love.service.param.SoLoveActivityParam;

/**
 * 活动 model
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@Service
public class SoLoveActivityModel {

	/**
	 * soLoveActivityWriteDao
	 */
	@Autowired
	private SoLoveActivityWriteDao soLoveActivityWriteDao;
	
	/**
	 * soLoveActivityReadDao
	 */
	@Autowired
	private SoLoveActivityReadDao soLoveActivityReadDao;
	
	/**
	 * 分页获取活动信息
	 * @param activity 查询参数
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 */
	public Map<String, Object> pageActivity(SoLoveActivityParam activity, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveActivityReadDao, "Property 'soLoveUserInfoReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");;
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "activity", activity );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = soLoveActivityReadDao.pageActivity(paramMap);
		Integer recordsTotal = soLoveActivityReadDao.pageActivityTotal(activity);
		
		/**
		 * 将结果按前台js分页插件的要求装进map
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("draw", draw);
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 新增一个活动
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	public Boolean addActivity(SoLoveActivityParam activity) {
		Assert.notNull(soLoveActivityWriteDao, "Property 'soLoveActivityWriteDao' is required.");
		if( activity == null ) throw new BusinessException("活动信息不能为空");
		
		Integer result = soLoveActivityWriteDao.addActivity(activity);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改活动信息
	 * 
	 * @param activity 活动信息
	 * @return
	 */
	public Boolean updateActivity(SoLoveActivityParam activity) {
		Assert.notNull(soLoveActivityWriteDao, "Property 'soLoveActivityWriteDao' is required.");
		if( activity == null ) throw new BusinessException("活动信息不能为空");
		
		Integer result = soLoveActivityWriteDao.updateActivity(activity);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除一个活动
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	public Boolean deleteActivity(Integer activityID) {
		Assert.notNull(soLoveActivityWriteDao, "Property 'soLoveActivityWriteDao' is required.");
		if( activityID == null ) throw new BusinessException("活动信息ID不能为空");
		
		Integer result = soLoveActivityWriteDao.deleteActivity(activityID);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查活动是否在报名中
	 * 
	 * @param activityID 活动ID
	 * @return true——验证通过，该活动没有在活动期限内
	 */
	public Boolean checkCurrent(Integer activityID) {
		Assert.notNull(soLoveActivityReadDao, "Property 'soLoveActivityReadDao' is required.");
		if( activityID == null ) throw new BusinessException("活动信息ID不能为空");
		
		Integer result = soLoveActivityReadDao.checkCurrent(activityID);
		if( result > 0 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据活动ID获取活动信息
	 * 
	 * @param activityID 活动ID
	 * @return
	 */
	public SoLoveActivityEntity getActivityByID(Integer activityID) {
		Assert.notNull(soLoveActivityReadDao, "Property 'soLoveActivityReadDao' is required.");
		if( activityID == null ) throw new BusinessException("活动信息ID不能为空");
		
		return soLoveActivityReadDao.getActivityByID(activityID);
	}

}
