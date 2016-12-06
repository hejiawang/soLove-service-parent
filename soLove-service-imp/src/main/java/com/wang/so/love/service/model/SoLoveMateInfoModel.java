package com.wang.so.love.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveMateInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveMateInfoWriteDao;
import com.wang.so.love.service.entity.SoLoveMateInfoEntity;
import com.wang.so.love.service.param.SoLoveMateInfoParam;

/**
 * 用户择偶信息Model
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
@Service
public class SoLoveMateInfoModel {

	/**
	 * soLoveMateInfoReadDao
	 */
	@Autowired
	private SoLoveMateInfoReadDao soLoveMateInfoReadDao;
	
	/**
	 * soLoveMateInfoWriteDao
	 */
	@Autowired
	private SoLoveMateInfoWriteDao soLoveMateInfoWriteDao;
	
	/**
	 * 修改(完善)用户择偶信息
	 * 
	 * @param mateInfo 用户择偶信息
	 * @return 是否修改成功
	 */
	public Boolean updateMateInfo(SoLoveMateInfoParam mateInfo) {
		Assert.notNull(soLoveMateInfoWriteDao, "Property 'soLoveMateInfoWriteDao' is required.");
		if( mateInfo.getUserID() == null ) throw new BusinessException("用户ID不能为空");
		
		Integer result = soLoveMateInfoWriteDao.updateMateInfo(mateInfo);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户ID获取该用户的择偶信息
	 * 
	 * @param userID 用户ID
	 * @return 用户详细信息
	 */
	public SoLoveMateInfoEntity getMateInfoByUserID(Integer userID) {
		Assert.notNull(soLoveMateInfoReadDao, "Property 'soLoveMateInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return soLoveMateInfoReadDao.getMateInfoByUserID( userID );
	}

}
