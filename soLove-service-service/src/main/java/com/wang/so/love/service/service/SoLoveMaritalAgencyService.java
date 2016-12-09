package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveMaritalAgencyEntity;
import com.wang.so.love.service.param.SoLoveMaritalAgencyParam;

/**
 * 婚介所信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
public interface SoLoveMaritalAgencyService {

	/**
	 * 新增婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 */
	public ServiceResult<Void> addMaritalAgency(SoLoveMaritalAgencyParam maritalAgency);
	
	/**
	 * 修改婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 */
	public ServiceResult<Void> updateMaritalAgency(SoLoveMaritalAgencyParam maritalAgency);
	
	/**
	 * 删除婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 */
	public ServiceResult<Void> deleteMaritalAgency(Integer maritalAgencyID);
	
	/**
	 * 获取婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 * @return 婚介所信息
	 */
	public ServiceResult<SoLoveMaritalAgencyEntity> getMaritalAgencyByID(Integer maritalAgencyID);
}
