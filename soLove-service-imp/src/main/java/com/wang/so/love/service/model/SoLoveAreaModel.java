package com.wang.so.love.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveAreaReadDao;
import com.wang.so.love.service.dao.write.SoLoveAreaWriteDao;
import com.wang.so.love.service.entity.SoLoveAreaEntity;
import com.wang.so.love.service.param.SoLoveAreaParam;

/**
 * 地区Model
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveAreaModel {

	/**
	 * soLoveAreaReadDao
	 */
	@Autowired
	private SoLoveAreaReadDao soLoveAreaReadDao;
	
	/**
	 * soloveAreaWriteDao
	 */
	@Autowired
	private SoLoveAreaWriteDao soLoveAreaWriteDao;
	
	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	public List<SoLoveAreaEntity> getAreaListByParentID(Integer parentID) {
		Assert.notNull(soLoveAreaReadDao, "Property 'soLoveAreaReadDao' is required.");
		if( parentID == null ) throw new BusinessException("地址父ID不能为空");
		
		return soLoveAreaReadDao.getAreaListByParentID(parentID);
	}

	/**
	 * 分页获取地区信息
	 * 
	 * @param param 查询信息
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Map<String, Object> pageAera(SoLoveAreaParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveAreaReadDao, "Property 'soLoveUserInfoReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "area", param );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = soLoveAreaReadDao.pageAera(paramMap);
		Integer recordsTotal = soLoveAreaReadDao.pageAreaTotal(param);
		
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
	 * 删除地区
	 * @param areaID 地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Boolean deleteArea(Integer areaID) {
		Assert.notNull(soLoveAreaWriteDao, "Property 'soLoveAreaWriteDao' is required.");
		if( areaID==null ) throw new BusinessException("地区ID不能为空");
		
		Integer result = soLoveAreaWriteDao.deleteArea(areaID);
		if( result > 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Boolean raiseArea(SoLoveAreaParam area) {
		Assert.notNull(soLoveAreaWriteDao, "Property 'soLoveAreaWriteDao' is required.");
		if( area==null ) throw new BusinessException("地区不能为空");
		
		Integer result = soLoveAreaWriteDao.addArea(area);
		if( result > 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Boolean modifyArea(SoLoveAreaParam area) {
		Assert.notNull(soLoveAreaWriteDao, "Property 'soLoveAreaWriteDao' is required.");
		if( area.getAreaID()==null ) throw new BusinessException("地区ID不能为空");
		
		Integer result = soLoveAreaWriteDao.updateArea(area);
		if( result > 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取地区树
	 * 
	 * @param id 父地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public List<SoLoveAreaParam> getAreaTreeData(Integer parentID) {
		Assert.notNull(soLoveAreaReadDao, "Property 'soLoveAreaReadDao' is required.");
		if( parentID == null ) throw new BusinessException("地址父ID不能为空");
		
		return soLoveAreaReadDao.getAreaTreeData(parentID);
	}

}
