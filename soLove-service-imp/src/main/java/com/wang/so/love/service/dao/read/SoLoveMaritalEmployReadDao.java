package com.wang.so.love.service.dao.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
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

}
