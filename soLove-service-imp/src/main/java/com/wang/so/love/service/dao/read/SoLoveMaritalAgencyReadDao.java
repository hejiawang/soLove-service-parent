package com.wang.so.love.service.dao.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveMaritalAgencyEntity;

/**
 * 婚介所信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.09
 */
@MyBatisRepository
public interface SoLoveMaritalAgencyReadDao {

	/**
	 * 获取婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 * @return 婚介所信息
	 */
	SoLoveMaritalAgencyEntity getMaritalAgencyByID(@Param("maritalAgencyID")Integer maritalAgencyID);

}
