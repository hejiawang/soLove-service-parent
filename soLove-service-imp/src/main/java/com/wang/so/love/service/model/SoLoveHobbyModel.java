package com.wang.so.love.service.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveHobbyReadDao;
import com.wang.so.love.service.dao.write.SoLoveHobbyWriteDao;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.param.SoLoveHobbyParam;

/**
 * 兴趣爱好Model
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveHobbyModel {

	/**
	 * soLoveHobbyReadDao
	 */
	@Autowired
	private SoLoveHobbyReadDao soLoveHobbyReadDao;
	
	/**
	 * SoLoveHobbyWriteDao
	 */
	@Autowired
	private SoLoveHobbyWriteDao SoLoveHobbyWriteDao;
	
	/**
	 * 新增兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 * @return 是否新增成功
	 */
	public Boolean addHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( hobby == null ) throw new BusinessException("兴趣爱好不能为空");
		
		Integer result = SoLoveHobbyWriteDao.addHobby(hobby);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 修改兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 * @return 是否修改成功
	 */
	public Boolean modifyHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( hobby.getHobbyID() == null ) throw new BusinessException("兴趣爱好ID不能为空");
		
		Integer result = SoLoveHobbyWriteDao.modifyHobby(hobby);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 删除兴趣爱好
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 是否删除成功
	 */
	public Boolean deleteHobby(Integer hobbyID) {
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( hobbyID == null ) throw new BusinessException("兴趣爱好ID不能为空");
		
		Integer result = SoLoveHobbyWriteDao.deleteHobby(hobbyID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 兴趣爱好
	 */
	public SoLoveHobbyEntity getHobbyByID(Integer hobbyID) {
		Assert.notNull(soLoveHobbyReadDao, "Property 'soLoveHobbyReadDao' is required.");
		if( hobbyID == null ) throw new BusinessException("兴趣爱好ID不能为空");
		
		return soLoveHobbyReadDao.getHobbyByID(hobbyID);
	}

	/**
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 * @return 兴趣爱好集合
	 */
	public List<SoLoveHobbyEntity> getHobbyByUserID(Integer userID) {
		Assert.notNull(soLoveHobbyReadDao, "Property 'soLoveHobbyReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return soLoveHobbyReadDao.getHobbyByUserID(userID);
	}

}
