package com.wang.so.love.service.service;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveActivityEntity;

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
	public ServiceResult<List<SoLoveActivityEntity>> getAreaListByParentID( Integer parentID ); 
}
