package com.wang.so.love.service.dao.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveUserDetailInfoEntity;

/**
 * 用户详细信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@MyBatisRepository
public interface SoLoveUserDetailInfoReadDao {

	/**
	 * 根据用户ID获取该用户详细信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	SoLoveUserDetailInfoEntity getUserDetailInfoByUserID( @Param("userID") Integer userID);

}
