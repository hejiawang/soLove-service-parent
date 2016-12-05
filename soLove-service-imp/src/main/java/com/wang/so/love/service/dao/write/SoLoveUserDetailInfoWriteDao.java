package com.wang.so.love.service.dao.write;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;

/**
 * 用户详细信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@MyBatisRepository
public interface SoLoveUserDetailInfoWriteDao {

	/**
	 * 修改(完善)用户详细信息
	 * 
	 * @param userDetailInfo 用户详细信息
	 */
	Integer updateUserDetailInfo(SoLoveUserDetailInfoParam userDetailInfo);

	/**
	 * 新建用户详细信息
	 * 
	 * @param userDetailInfo
	 */
	Integer insertUserDetailInfo(SoLoveUserDetailInfoParam userDetailInfo);
}
