package com.wang.so.love.service.dao.write;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 
 * 登录注册 write dao
 * 
 * @author HeJiawang
 * @date   2016.12.02
 *
 */
@MyBatisRepository
public interface SoLoveLoginWriteDao {

	/**
	 * 注册用户
	 * @param userInfo 登录手机号与密码
	 * @return userInfo 登录手机号与密码 和 userID
	 * @author HeJiawang
	 * @date   2016.12.02
	 */
	Integer registerUserInfo(SoLoveUserInfoParam userInfo);

}
