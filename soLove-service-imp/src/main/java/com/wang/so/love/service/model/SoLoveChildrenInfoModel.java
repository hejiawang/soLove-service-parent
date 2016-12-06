package com.wang.so.love.service.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveChildrenInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveChildrenInfoWriteDao;
import com.wang.so.love.service.entity.SoLoveChildrenInfoEntity;
import com.wang.so.love.service.param.SoLoveChildrenInfoParam;

/**
 * 用户子女信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveChildrenInfoModel {

	/**
	 * soLoveChildrenInfoReadDao
	 */
	@Autowired
	private SoLoveChildrenInfoReadDao soLoveChildrenInfoReadDao;
	
	/**
	 * soLoveChildrenWriteReadDao
	 */
	@Autowired
	private SoLoveChildrenInfoWriteDao soLoveChildrenWriteReadDao;
	
	/**
	 * 新增用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 * @return 是否成功
	 */
	public Boolean addChildrenInfo(SoLoveChildrenInfoParam childrenInfo) {
		Assert.notNull(soLoveChildrenWriteReadDao, "Property 'soLoveChildrenWriteReadDao' is required.");
		if( childrenInfo.getUserID() == null ) throw new BusinessException("所属用户不能为空");
		if( StringUtils.isBlank(childrenInfo.getChildrenRelation()) ) throw new BusinessException("子女关系不能为空");
		
		Integer result = soLoveChildrenWriteReadDao.insertChildrenInfo(childrenInfo);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 修改用户子女信息
	 * 
	 * @param childrenInfo 用户子女信息
	 * @return 是否成功
	 */
	public Boolean updateChildrenInfo(SoLoveChildrenInfoParam childrenInfo) {
		Assert.notNull(soLoveChildrenWriteReadDao, "Property 'soLoveChildrenWriteReadDao' is required.");
		if( childrenInfo.getUserID() == null ) throw new BusinessException("所属用户不能为空");
		if( StringUtils.isBlank(childrenInfo.getChildrenRelation()) ) throw new BusinessException("子女关系不能为空");
		
		Integer result = soLoveChildrenWriteReadDao.updateChildrenInfo(childrenInfo);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据子女信息ID删除用户子女信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return 是否成功
	 */
	public Boolean deleteChildrenInfo(Integer childrenID) {
		Assert.notNull(soLoveChildrenWriteReadDao, "Property 'soLoveChildrenWriteReadDao' is required.");
		if( childrenID == null ) throw new BusinessException("子女信息ID不能为空");
		
		Integer result = soLoveChildrenWriteReadDao.deleteChildrenInfo(childrenID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据子女信息ID获取用户子女详细信息
	 * 
	 * @param childrenID 用户子女信息ID
	 * @return 用户子女信息
	 */
	public SoLoveChildrenInfoEntity getChildrenInfoByID(Integer childrenID) {
		Assert.notNull(soLoveChildrenInfoReadDao, "Property 'soLoveChildrenInfoReadDao' is required.");
		if( childrenID == null ) throw new BusinessException("子女信息ID不能为空");
		
		return soLoveChildrenInfoReadDao.getChildrenInfoByID(childrenID);
	}

	/**
	 * 根据用户ID获取该用户的所有子女
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有子女信息
	 */
	public List<SoLoveChildrenInfoEntity> getChildrenInfoByUserID(Integer userID) {
		Assert.notNull(soLoveChildrenInfoReadDao, "Property 'soLoveChildrenInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户信息ID不能为空");
		
		return soLoveChildrenInfoReadDao.getChildrenInfoByUserID(userID);
	}

}
