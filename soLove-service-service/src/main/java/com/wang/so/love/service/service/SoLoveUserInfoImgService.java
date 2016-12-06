package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveUserInfoImgEntity;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;

/**
 * 用户图片信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
public interface SoLoveUserInfoImgService {
	
	/**
	 * 更新用户照片
	 * 
	 * @param userInfoImg 用户照片信息
	 */
	public ServiceResult<Void> updateUserInfoImg(SoLoveUserInfoImgParam userInfoImg);
	
	/**
	 * 根据用户ID获取用户照片信息
	 * 
	 * @param userID 用户ID
	 * @return 用户照片信息
	 */
	public ServiceResult<SoLoveUserInfoImgEntity> getUserInfoImgByUserID(Integer userID);
}
