package com.wang.so.love.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveMaritalEmployReadDao;
import com.wang.so.love.service.dao.write.SoLoveMaritalEmployWriteDao;
import com.wang.so.love.service.param.SoLoveMaritalEmployParam;
import com.wang.so.love.service.vo.SoLoveMaritalEmployVO;

/**
 * 婚介所工作人员信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
@Service
public class SoLoveMaritalEmployModel {

	/**
	 * SoLoveMaritalEmployReadDao
	 */
	@Autowired
	private SoLoveMaritalEmployReadDao SoLoveMaritalEmployReadDao;
	
	/**
	 * SoLoveMaritalEmployWriteDao
	 */
	@Autowired
	private SoLoveMaritalEmployWriteDao SoLoveMaritalEmployWriteDao;
	
	/**
	 * 新增婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 是否成功
	 */
	public Boolean addMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy) {
		Assert.notNull(SoLoveMaritalEmployWriteDao, "Property 'SoLoveMaritalEmployWriteDao' is required.");
		if( maritalEmploy == null ) throw new BusinessException("婚介所工作人员信息不能为空");
		
		Integer result = SoLoveMaritalEmployWriteDao.addMaritalEmploy(maritalEmploy);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 修改婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 是否成功
	 */
	public Boolean updateMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy) {
		Assert.notNull(SoLoveMaritalEmployWriteDao, "Property 'SoLoveMaritalEmployWriteDao' is required.");
		if( maritalEmploy == null ) throw new BusinessException("婚介所工作人员信息不能为空");
		
		Integer result = SoLoveMaritalEmployWriteDao.updateMaritalEmploy(maritalEmploy);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 删除婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 是否成功
	 */
	public Boolean deleteMaritalEmploy(Integer maritalEmployID) {
		Assert.notNull(SoLoveMaritalEmployWriteDao, "Property 'SoLoveMaritalEmployWriteDao' is required.");
		if( maritalEmployID == null ) throw new BusinessException("婚介所工作人员信息ID不能为空");
		
		Integer result = SoLoveMaritalEmployWriteDao.deleteMaritalEmploy(maritalEmployID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 查看婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 婚介所工作人员以及所在婚介所的信息
	 */
	public SoLoveMaritalEmployVO getMaritalEmploy(Integer maritalEmployID) {
		Assert.notNull(SoLoveMaritalEmployReadDao, "Property 'SoLoveMaritalEmployReadDao' is required.");
		if( maritalEmployID == null ) throw new BusinessException("婚介所ID不能为空");
		
		return SoLoveMaritalEmployReadDao.getMaritalEmploy(maritalEmployID);
	}

}
