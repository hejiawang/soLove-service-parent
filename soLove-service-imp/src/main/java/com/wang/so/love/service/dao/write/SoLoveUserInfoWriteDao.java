package com.wang.so.love.service.dao.write;

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

}
