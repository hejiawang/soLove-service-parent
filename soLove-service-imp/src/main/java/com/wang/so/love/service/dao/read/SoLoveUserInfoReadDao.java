package com.wang.so.love.service.dao.read;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveUserInfoParam;

/**
 * 用户信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveUserInfoReadDao {

	/**
	 * 检查loginName是否重复
	 * @param userInfo 用户信息
	 * @return  >=1代表重复
	 */
	Integer checkLoginName(SoLoveUserInfoParam userInfo);

}
