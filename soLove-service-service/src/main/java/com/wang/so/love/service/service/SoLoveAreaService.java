package com.wang.so.love.service.service;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveAreaEntity;
import com.wang.so.love.service.param.SoLoveAreaParam;

/**
 * 地区接口
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
public interface SoLoveAreaService {
	
	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	public ServiceResult<List<SoLoveAreaEntity>> getAreaListByParentID( Integer parentID );

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
	public ServiceResult<Map<String,Object>> pageAera(SoLoveAreaParam param, Integer start, Integer length, Integer draw);

	/**
	 * 删除地区
	 * @param areaID 地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Void> deleteArea(Integer areaID);

	/**
	 * 新增地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Void> raiseArea(SoLoveAreaParam area);

	/**
	 * 修改地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Void> modifyArea(SoLoveAreaParam area);

	/**
	 * 获取地区树
	 * 
	 * @param id 父地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<List<SoLoveAreaParam>> getAreaTreeData(Integer parentID); 
}
