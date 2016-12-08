package com.wang.so.love.service.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveAreaReadDao;
import com.wang.so.love.service.entity.SoLoveActivityEntity;

/**
 * 地区Model
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveAreaModel {

	/**
	 * soLoveAreaReadDao
	 */
	@Autowired
	private SoLoveAreaReadDao soLoveAreaReadDao;
	
	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	public List<SoLoveActivityEntity> getAreaListByParentID(Integer parentID) {
		Assert.notNull(soLoveAreaReadDao, "Property 'soLoveAreaReadDao' is required.");
		if( parentID == null ) throw new BusinessException("地址父ID不能为空");
		
		return soLoveAreaReadDao.getAreaListByParentID(parentID);
	}

}
