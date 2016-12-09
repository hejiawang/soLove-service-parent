package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMaritalEmployParam;

/**
 * 婚介所工作人员信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.09
 */
@MyBatisRepository
public interface SoLoveMaritalEmployWriteDao {

	/**
	 * 新增婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	Integer addMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy);

	/**
	 * 修改婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	Integer updateMaritalEmploy(SoLoveMaritalEmployParam maritalEmploy);

	/**
	 * 删除婚介所工作人员
	 *  
	 * @param maritalEmploy
	 */
	Integer deleteMaritalEmploy(@Param("maritalEmployID")Integer maritalEmployID);

}
