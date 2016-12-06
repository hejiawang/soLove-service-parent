package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveParentInfoParam;

/**
 * 用户父母信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveParentInfoWriteDao {

	/**
	 * 新增用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 */
	Integer insertParentInfo(SoLoveParentInfoParam parentInfo);

	/**
	 * 修改用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 */
	Integer updateParentInfo(SoLoveParentInfoParam parentInfo);

	/**
	 * 根据父母信息ID删除用户父母信息
	 * 
	 * @param parentInfoID 用户父母信息ID
	 */
	Integer deleteParentInfo(@Param("parentID")Integer parentID);

}
