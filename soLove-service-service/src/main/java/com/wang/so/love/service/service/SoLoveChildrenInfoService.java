package com.wang.so.love.service.service;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveChildrenInfoEntity;
import com.wang.so.love.service.param.SoLoveChildrenInfoParam;

/**
 * 用户子女信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
public interface SoLoveChildrenInfoService {
	
	/**
	 * 新增用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 * @return ServiceResult
	 */
	public ServiceResult<Void> addChildrenInfo(SoLoveChildrenInfoParam childrenInfo);
	
	/**
	 * 修改用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 * @return ServiceResult
	 */
	public ServiceResult<Void> updateChildrenInfo(SoLoveChildrenInfoParam childrenInfo);
	
	/**
	 * 根据子女信息ID删除用户子女信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return ServiceResult
	 */
	public ServiceResult<Void> deleteChildrenInfo(Integer childrenID);
	
	/**
	 * 根据子女信息ID获取用户子女详细信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return 用户子女信息
	 */
	public ServiceResult<SoLoveChildrenInfoEntity> getChildrenInfoByID(Integer childrenID);
	
	/**
	 * 根据用户ID获取该用户的所有子女
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有子女信息
	 */
	public ServiceResult<List<SoLoveChildrenInfoEntity>> getChildrenInfoByUserID(Integer userID);

	/**
	 * 修改用户子女信息
	 * 
	 * @return ServiceResult
	 * 
	 * @author HeJiawang
	 * @date   2016.12.28
	 */
	public ServiceResult<Void> modifyUserChildren(List<SoLoveChildrenInfoParam> childrenInfoList, Integer userID);
}
