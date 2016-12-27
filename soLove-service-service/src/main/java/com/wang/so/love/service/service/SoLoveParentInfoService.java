package com.wang.so.love.service.service;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveParentInfoEntity;
import com.wang.so.love.service.param.SoLoveParentInfoParam;

/**
 * 用户父母信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
public interface SoLoveParentInfoService {
	
	/**
	 * 新增用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 * @return ServiceResult
	 */
	public ServiceResult<Void> addParentInfo(SoLoveParentInfoParam parentInfo);
	
	/**
	 * 修改用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 * @return ServiceResult
	 */
	public ServiceResult<Void> updateParentInfo(SoLoveParentInfoParam parentInfo);
	
	/**
	 * 根据父母信息ID删除用户父母信息
	 * 
	 * @param parentID 用户父母信息ID
	 * @return ServiceResult
	 */
	public ServiceResult<Void> deleteParentInfo(Integer parentID);
	
	/**
	 * 根据父母信息ID获取用户父母详细信息
	 * 
	 * @param parentID 用户父母信息ID
	 * @return 用户父母信息
	 */
	public ServiceResult<SoLoveParentInfoEntity> getParentInfoByID(Integer parentID);
	
	/**
	 * 根据用户ID获取该用户的所有父母
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有父母信息
	 */
	public ServiceResult<List<SoLoveParentInfoEntity>> getParentInfoByUserID(Integer userID);

	/**
	 * 修改用户父母信息
	 * 
	 * @return ServiceResult
	 * 
	 * @author HeJiawang
	 * @date   2016.12.27
	 */
	public ServiceResult<Void> modifyUserParent(List<SoLoveParentInfoParam> parentInfoList, Integer userID);
}
