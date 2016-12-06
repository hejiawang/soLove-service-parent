package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveUserDetailInfoEntity;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;

/**
 * 用户详细信息
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
public interface SoLoveUserDetailInfoService {
	
	/**
	 * 修改(完善)用户详细信息
	 * 
	 * @param userDetailInfo 用户详细信息
	 */
	public ServiceResult<Void> updateUserDetailInfo( SoLoveUserDetailInfoParam userDetailInfo );
	
	/**
	 * 根据用户ID获取该用户详细信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	public ServiceResult<SoLoveUserDetailInfoEntity> getUserDetailInfoByUserID( Integer userID );
}
