package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveHobbyParam;

/**
 * 兴趣爱好——写
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@MyBatisRepository
public interface SoLoveHobbyWriteDao {

	/**
	 * 新增兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 * @return 是否新增成功
	 */
	Integer addHobby(SoLoveHobbyParam hobby);

	/**
	 * 修改兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 * @return 是否修改成功
	 */
	Integer modifyHobby(SoLoveHobbyParam hobby);

	/**
	 * 删除兴趣爱好
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 是否删除成功
	 */
	Integer deleteHobby(@Param("hobbyID")Integer hobbyID);

	/**
	 * 删除用户兴趣爱好表中已有的关联数据
	 * 
	 * @param userID 用户ID
	 */
	Integer deleteUserHobby(@Param("userID")Integer userID);

	/**
	 * 新增新的用户兴趣爱好关联信息
	 * 
	 * @param userID 用户ID
	 * @param hobbyID 兴趣爱好ID
	 */
	Integer addUserHobby(@Param("userID")Integer userID, @Param("hobbyID")Integer hobbyID);

}
