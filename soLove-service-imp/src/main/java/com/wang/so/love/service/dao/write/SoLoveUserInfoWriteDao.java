package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 用户信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveUserInfoWriteDao {

	/**
	 * 新增用户
	 * 
	 * @param userInfo 用户信息——登录手机号、密码
	 * @return 在实体中返回userID
	 */
	Integer insertUserInfo(SoLoveUserInfoParam userInfo);

	/**
	 * 删除用户
	 * 
	 * @param userID 用户ID
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	Integer deleteUserInfo(@Param("userID")Integer userID);
	
	/**
	 * 更改用户等级
	 * 
	 * @param userLevel 用户等级
	 * 
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	Integer updateUserLevel(@Param("userLevel")String userLevel, @Param("userID")Integer userID);


	/**
	 * 修改用户基本信息
	 * 
	 * @param userInfo 用户基本信息参数
	 * 
	 * @author HeJiawang
	 * @date   2016.12.27
	 */
	Integer updateUserInfo(SoLoveUserInfoParam userInfo);

}
