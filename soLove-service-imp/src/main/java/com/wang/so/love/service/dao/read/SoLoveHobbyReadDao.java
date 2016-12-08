package com.wang.so.love.service.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;

/**
 * 兴趣爱好——读
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@MyBatisRepository
public interface SoLoveHobbyReadDao {

	/**
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 兴趣爱好
	 */
	SoLoveHobbyEntity getHobbyByID(@Param("hobbyID")Integer hobbyID);

	/**
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 * @return 兴趣爱好集合
	 */
	List<SoLoveHobbyEntity> getHobbyByUserID(@Param("userID")Integer userID);

}
