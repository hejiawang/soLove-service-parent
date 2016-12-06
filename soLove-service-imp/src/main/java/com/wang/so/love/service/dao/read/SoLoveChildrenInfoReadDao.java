package com.wang.so.love.service.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveChildrenInfoEntity;

/**
 * 用户子女信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveChildrenInfoReadDao {

	/**
	 * 根据子女信息ID获取用户子女详细信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return 用户子女信息
	 */
	SoLoveChildrenInfoEntity getChildrenInfoByID(@Param("childrenID")Integer childrenID);

	/**
	 * 根据用户ID获取该用户的所有子女
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有子女信息
	 */
	List<SoLoveChildrenInfoEntity> getChildrenInfoByUserID(@Param("userID")Integer userID);

}
