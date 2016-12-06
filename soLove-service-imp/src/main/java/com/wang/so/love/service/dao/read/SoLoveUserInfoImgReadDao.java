package com.wang.so.love.service.dao.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveUserInfoImgEntity;

/**
 * 用户照片信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveUserInfoImgReadDao {

	/**
	 * 根据用户ID获取用户照片信息
	 * 
	 * @param userID 用户ID
	 * @return 用户照片信息
	 */
	SoLoveUserInfoImgEntity getUserInfoImgByUserID(@Param("userID")Integer userID);

}
