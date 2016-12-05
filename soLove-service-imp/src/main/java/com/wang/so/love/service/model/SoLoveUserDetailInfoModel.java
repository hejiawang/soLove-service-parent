package com.wang.so.love.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveUserDetailInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveUserDetailInfoWriteDao;
import com.wang.so.love.service.entity.SoLoveUserDetailInfoEntity;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;

/**
 * 用户详细信息Model
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@Service
public class SoLoveUserDetailInfoModel {

	/**
	 * soloveUserDetailInfoReadDao
	 */
	@Autowired
	private SoLoveUserDetailInfoReadDao soloveUserDetailInfoReadDao;
	
	/**
	 * soloveUserDetailInfoWriteDao
	 */
	@Autowired
	private SoLoveUserDetailInfoWriteDao soloveUserDetailInfoWriteDao;
	
	/**
	 * 修改(完善)用户详细信息
	 * 
	 * @param userDetailInfo 用户详细信息
	 */
	public Boolean updateUserDetailInfo(SoLoveUserDetailInfoParam userDetailInfo) {
		Assert.notNull(soloveUserDetailInfoWriteDao, "Property 'soloveUserDetailInfoWriteDao' is required.");
		if( userDetailInfo.getUserID() == null ) throw new BusinessException("用户ID不能为空");
		
		Integer result = soloveUserDetailInfoWriteDao.updateUserDetailInfo(userDetailInfo);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户ID获取该用户详细信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	public SoLoveUserDetailInfoEntity getUserDetailInfoByID(Integer userID) {
		Assert.notNull(soloveUserDetailInfoReadDao, "Property 'soloveUserDetailInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return soloveUserDetailInfoReadDao.getUserDetailInfoByID( userID );
	}

}
