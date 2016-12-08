package com.wang.so.love.service.dao.write;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMemberInfoParam;

/**
 * 会员信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.08
 */
@MyBatisRepository
public interface SoLoveMemberInfoWriteDao {

	/**
	 * 开通一个会员
	 * 
	 * @param memberInfo 会员信息
	 */
	Integer insertMemberInfo(SoLoveMemberInfoParam memberInfo);

}
