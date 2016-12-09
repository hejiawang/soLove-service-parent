package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.param.SoLoveMaritalEmployParam;
import com.wang.so.love.service.vo.SoLoveMaritalEmployVO;

/**
 * 婚介所工作人员信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
public interface SoLoveMaritalEmployService {
	
	/**
	 * 新增婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	public ServiceResult<Void> addMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy);
	
	/**
	 * 修改婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	public ServiceResult<Void> updateMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy);
	
	/**
	 * 删除婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	public ServiceResult<Void> deleteMaritalEmploy(Integer maritalEmployID);
	
	/**
	 * 查看婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 婚介所工作人员以及所在婚介所的信息
	 */
	public ServiceResult<SoLoveMaritalEmployVO> getMaritalEmploy(Integer maritalEmployID);
}
