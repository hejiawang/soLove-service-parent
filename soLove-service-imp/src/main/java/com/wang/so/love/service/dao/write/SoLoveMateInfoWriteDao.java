package com.wang.so.love.service.dao.write;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMateInfoParam;

/**
 * 用户择偶信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@MyBatisRepository
public interface SoLoveMateInfoWriteDao {

	/**
	 * 修改(完善)用户择偶信息
	 * 
	 * @param mateInfo 用户择偶信息
	 */
	Integer updateMateInfo(SoLoveMateInfoParam mateInfo);

}
