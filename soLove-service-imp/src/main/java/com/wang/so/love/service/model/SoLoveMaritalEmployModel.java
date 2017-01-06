package com.wang.so.love.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private SoLoveMaritalEmployReadDao soLoveMaritalEmployReadDao;
	
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
		Assert.notNull(soLoveMaritalEmployReadDao, "Property 'SoLoveMaritalEmployReadDao' is required.");
		if( maritalEmployID == null ) throw new BusinessException("婚介所ID不能为空");
		
		return soLoveMaritalEmployReadDao.getMaritalEmploy(maritalEmployID);
	}

	/**
	 * 分页获取婚介所老师信息
	 * @param param 查询信息
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2017.01.06
	 */
	public Map<String, Object> pageMaritalEmploy(SoLoveMaritalEmployParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveMaritalEmployReadDao, "Property 'SoLoveMaritalEmployReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "maritalEmploy", param );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = soLoveMaritalEmployReadDao.pageMaritalEmploy(paramMap);
		Integer recordsTotal = soLoveMaritalEmployReadDao.pageMaritalEmployTotal(param);
		
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
