package com.wang.so.love.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveMaritalAgencyReadDao;
import com.wang.so.love.service.dao.write.SoLoveMaritalAgencyWriteDao;
import com.wang.so.love.service.entity.SoLoveMaritalAgencyEntity;
import com.wang.so.love.service.param.SoLoveMaritalAgencyParam;

/**
 * 婚介所信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
@Service
public class SoLoveMaritalAgencyModel {

	/**
	 * soLoveMaritalAgencyReadDao
	 */
	@Autowired
	private SoLoveMaritalAgencyReadDao soLoveMaritalAgencyReadDao;
	
	/**
	 * soLoveMaritalAgencyWriteDao
	 */
	@Autowired
	private SoLoveMaritalAgencyWriteDao soLoveMaritalAgencyWriteDao;
	
	/**
	 * 新增婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 * @return 是否成功
	 */
	public Boolean addMaritalAgency(SoLoveMaritalAgencyParam maritalAgency) {
		Assert.notNull(soLoveMaritalAgencyWriteDao, "Property 'soLoveMaritalAgencyWriteDao' is required.");
		if( maritalAgency == null ) throw new BusinessException("婚介所信息不能为空");
		
		Integer result = soLoveMaritalAgencyWriteDao.addMaritalAgency(maritalAgency);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 修改婚介所信息
	 * 
	 * @param maritalAgency 婚介所信息
	 * @return 是否成功
	 */
	public Boolean updateMaritalAgency(SoLoveMaritalAgencyParam maritalAgency) {
		Assert.notNull(soLoveMaritalAgencyWriteDao, "Property 'soLoveMaritalAgencyWriteDao' is required.");
		if( maritalAgency.getMaritalAgencyID() == null ) throw new BusinessException("婚介所信息不能为空");
		
		Integer result = soLoveMaritalAgencyWriteDao.updateMaritalAgency(maritalAgency);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 删除婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 * @return 是否成功
	 */
	public Boolean deleteMaritalAgency(Integer maritalAgencyID) {
		Assert.notNull(soLoveMaritalAgencyWriteDao, "Property 'soLoveMaritalAgencyWriteDao' is required.");
		if( maritalAgencyID == null ) throw new BusinessException("婚介所ID不能为空");
		
		Integer result = soLoveMaritalAgencyWriteDao.deleteMaritalAgency(maritalAgencyID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 获取婚介所信息
	 * 
	 * @param maritalAgencyID 婚介所ID
	 * @return 婚介所信息
	 */
	public SoLoveMaritalAgencyEntity getMaritalAgencyByID(Integer maritalAgencyID) {
		Assert.notNull(soLoveMaritalAgencyReadDao, "Property 'soLoveMaritalAgencyReadDao' is required.");
		if( maritalAgencyID == null ) throw new BusinessException("婚介所ID不能为空");
		
		return soLoveMaritalAgencyReadDao.getMaritalAgencyByID(maritalAgencyID);
	}

	/**
	 * 分页获取婚介所信息
	 * 
	 * @param param 查询信息
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.30
	 */
	public Map<String, Object> pageMaritalAgency(SoLoveMaritalAgencyParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveMaritalAgencyReadDao, "Property 'soLoveMaritalAgencyReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "maritalAgency", param );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = soLoveMaritalAgencyReadDao.pageMaritalAgency(paramMap);
		Integer recordsTotal = soLoveMaritalAgencyReadDao.pageMaritalAgencyTotal(param);
		
		/**
		 * 将结果按前台js分页插件的要求装进map
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("draw", draw);
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}
}
