package com.wang.so.love.service.service;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.param.SoLoveMemberInfoParam;

/**
 * 会员信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
public interface SoLoveMemberInfoService {
	
	/**
	 * 为用户开通会员
	 * 
	 * @param memberInfo 会员信息
	 */
	public ServiceResult<Void> openMemberForUser(SoLoveMemberInfoParam memberInfo);
}