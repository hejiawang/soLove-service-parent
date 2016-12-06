package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveChildrenInfoParam;

/**
 * 用户子女信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveChildrenInfoWriteDao {

	/**
	 * 新增用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 */
	Integer insertChildrenInfo(SoLoveChildrenInfoParam childrenInfo);

	/**
	 * 修改用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 */
	Integer updateChildrenInfo(SoLoveChildrenInfoParam childrenInfo);

	/**
	 * 根据子女信息ID删除用户子女信息
	 * 
	 * @param childrenID 用户子女信息ID
	 */
	Integer deleteChildrenInfo(@Param("childrenID")Integer childrenID);

}
