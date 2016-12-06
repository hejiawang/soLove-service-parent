package com.wang.so.love.service.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveParentInfoEntity;

/**
 * 用户父母信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveParentInfoReadDao {

	/**
	 * 根据父母信息ID获取用户父母详细信息
	 * 
	 * @param parentID 用户父母信息ID
	 * @return 用户父母信息
	 */
	SoLoveParentInfoEntity getParentInfoByID(@Param("parentID")Integer parentID);

	/**
	 * 根据用户ID获取该用户的所有父母
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有父母信息
	 */
	List<SoLoveParentInfoEntity> getParentInfoByUserID(@Param("userID")Integer userID);

}
