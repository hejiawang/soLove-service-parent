package com.wang.so.love.service.dao.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveMaritalAgencyEntity;
import com.wang.so.love.service.param.SoLoveMaritalAgencyParam;

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

	/**
	 * 获取分页数据
	 * @param paramMap 分页查询条件
	 * @return
	 */
	List<Map<String, Object>> pageMaritalAgency(Map<String, Object> paramMap);

	/**
	 * 获取分页数据条目
	 * @param param 查询参数
	 * @return
	 */
	Integer pageMaritalAgencyTotal(SoLoveMaritalAgencyParam param);

}
