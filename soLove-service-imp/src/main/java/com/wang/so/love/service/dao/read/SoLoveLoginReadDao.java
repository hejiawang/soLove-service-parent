package com.wang.so.love.service.dao.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 
 * 登录注册 read dao
 * 
 * @author HeJiawang
 * @date   2016.12.02
 *
 */
@MyBatisRepository
public interface SoLoveLoginReadDao {

	/**
	 * 登录——根据手机号与密码获取用户
	 * 
	 * @param loginName 登录手机号
	 * @param passWord 密码 
	 * @return SoLoveUserInfoParam
	 */
	SoLoveUserInfoParam getUserInfoByLoginNameAndPwd(@Param("loginName")String loginName, @Param("passWord")String passWord);

}
