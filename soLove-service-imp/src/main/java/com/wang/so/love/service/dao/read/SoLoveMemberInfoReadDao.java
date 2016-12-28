package com.wang.so.love.service.dao.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveMemberInfoEntity;

/**
 * 会员信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.08
 */
@MyBatisRepository
public interface SoLoveMemberInfoReadDao {

	/**
	 * 会员信息查看
	 * 
	 * @param userID 用户ID
	 * @return 会员信息
	 * 
	 * @author HeJiawang
	 * @date 2016.12.28
	 */
	SoLoveMemberInfoEntity getMemberInfoByUserID(@Param("userID")Integer userID);

}
