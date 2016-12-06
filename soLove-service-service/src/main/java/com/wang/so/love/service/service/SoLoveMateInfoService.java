package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveMateInfoEntity;
import com.wang.so.love.service.param.SoLoveMateInfoParam;

/**
 * 用户择偶信息接口
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
public interface SoLoveMateInfoService {

	/**
	 * 修改(完善)用户择偶信息
	 * 
	 * @param mateInfo 用户择偶信息
	 */
	public ServiceResult<Void> updateMateInfo( SoLoveMateInfoParam mateInfo );
	
	/**
	 * 根据用户ID获取该用户的择偶信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	public ServiceResult<SoLoveMateInfoEntity> getMateInfoByUserID( Integer userID );
}
