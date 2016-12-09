package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMaritalAgencyParam;

/**
 * 婚介所信息——写
 * 
 * @author HeJiawang
 * @date   2016.12.09
 */
@MyBatisRepository
public interface SoLoveMaritalAgencyWriteDao {

	/**
	 * 新增婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 */
	Integer addMaritalAgency(SoLoveMaritalAgencyParam maritalAgency);

	/**
	 * 修改婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 */
	Integer updateMaritalAgency(SoLoveMaritalAgencyParam maritalAgency);

	/**
	 * 删除婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 */
	Integer deleteMaritalAgency(@Param("maritalAgencyID")Integer maritalAgencyID);

}
