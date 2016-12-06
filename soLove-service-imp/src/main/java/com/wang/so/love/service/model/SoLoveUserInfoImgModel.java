package com.wang.so.love.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveUserInfoImgReadDao;
import com.wang.so.love.service.dao.write.SoLoveUserInfoImgWriteDao;
import com.wang.so.love.service.entity.SoLoveUserInfoImgEntity;
import com.wang.so.love.service.param.SoLoveUserInfoImgParam;

/**
 * 用户图片信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveUserInfoImgModel {

	/**
	 * soLoveUserInfoImgReadDao
	 */
	@Autowired
	private SoLoveUserInfoImgReadDao soLoveUserInfoImgReadDao;
	
	/**
	 * soLoveUserInfoImgWriteDao
	 */
	@Autowired
	private SoLoveUserInfoImgWriteDao soLoveUserInfoImgWriteDao;
	
	/**
	 * 更新用户照片
	 * 
	 * @param userInfoImg 用户照片信息
	 * @return 是否更新成功
	 */
	public Boolean updateUserInfoImg(SoLoveUserInfoImgParam userInfoImg) {
		Assert.notNull(soLoveUserInfoImgWriteDao, "Property 'soLoveUserInfoImgWriteDao' is required.");
		if( userInfoImg.getUserID() == null ) throw new BusinessException("用户ID不能为空");
		
		Integer result = soLoveUserInfoImgWriteDao.updateUserInfoImg(userInfoImg);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户ID获取用户照片信息
	 * 
	 * @param userID 用户ID
	 * @return 用户照片信息
	 */
	public SoLoveUserInfoImgEntity getUserInfoImgByUserID(Integer userID) {
		Assert.notNull(soLoveUserInfoImgReadDao, "Property 'soloveUserDetailInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return soLoveUserInfoImgReadDao.getUserInfoImgByUserID( userID );
	}

}
