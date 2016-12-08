package com.wang.so.love.service.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveActivityEntity;

/**
 * 地区——读
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@MyBatisRepository
public interface SoLoveAreaReadDao {

	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	List<SoLoveActivityEntity> getAreaListByParentID(@Param("parentID")Integer parentID);

}
