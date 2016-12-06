package com.wang.so.love.service.dao.write;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;

/**
 * 用户照片信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveUserInfoImgWriteDao {

	/**
	 * 更新用户照片
	 * 
	 * @param userInfoImg 用户照片信息
	 */
	Integer updateUserInfoImg(SoLoveUserInfoImgParam userInfoImg);
	
	/**
	 * 新建用户照片信息
	 * 
	 * @param userInfoImg 用户照片信息
	 */
	Integer insertUserInfoImg(SoLoveUserInfoImgParam userInfoImg);

}
