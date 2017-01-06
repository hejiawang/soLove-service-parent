package com.wang.so.love.service.service;

import java.util.Map;

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

	/**
	 * 分页获取婚介所老师信息
	 * @param param 查询信息
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2017.01.06
	 */
	public ServiceResult<Map<String,Object>> pageMaritalEmploy(SoLoveMaritalEmployParam param, Integer start, Integer length, Integer draw);
}
