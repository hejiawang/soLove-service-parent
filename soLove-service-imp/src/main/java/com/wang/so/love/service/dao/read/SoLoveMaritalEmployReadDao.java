package com.wang.so.love.service.dao.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMaritalEmployParam;
import com.wang.so.love.service.vo.SoLoveMaritalEmployVO;

/**
 * 婚介所工作人员信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.09
 */
@MyBatisRepository
public interface SoLoveMaritalEmployReadDao {

	/**
	 * 查看婚介所工作人员
	 *  
	 * @param maritalEmploy
	 * @return 婚介所工作人员以及所在婚介所的信息
	 */
	SoLoveMaritalEmployVO getMaritalEmploy(@Param("maritalEmployID")Integer maritalEmployID);

	/**
	 * 分页获取婚介所工作人员信息
	 * @param paramMap 查询信息
	 * @return 分页数据
	 * 
	 * @author HeJiawang
	 * @date   2017.01.06
	 */
	List<Map<String, Object>> pageMaritalEmploy(Map<String, Object> paramMap);

	/**
	 * 获取分页信息条数
	 * @param param 分页查询信息
	 * @return 分页条数
	 * 
	 * @author HeJiawang
	 * @date   2017.01.06
	 */
	Integer pageMaritalEmployTotal(SoLoveMaritalEmployParam param);

}
