package com.wang.so.love.service.dao.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveUserInfoEntity;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.param.SoLoveUserInfoParam;
import com.wang.so.love.service.vo.SoLoveUserSimpleInfoVO;

/**
 * 用户信息——读
 * 
 * @author HeJiawang
 * @date   2016.12.06
 */
@MyBatisRepository
public interface SoLoveUserInfoReadDao {

	/**
	 * 检查loginName是否重复
	 * @param userInfo 用户信息
	 * @return  >=1代表重复
	 */
	Integer checkLoginName(SoLoveUserInfoParam userInfo);

	/**
	 * 根据择偶条件筛选信息</br>
	 * 并进行分页
	 * 
	 * @param mateInfo 择偶信息
	 * @return 简单的用户信息,如：年龄、兴趣爱好等
	 * 
	 * @author HeJiawang
	 * @date   2016.12.07
	 */
	List<SoLoveUserSimpleInfoVO> getUserByMateInfo(SoLoveMateInfoParam mateInfo);

	/**
	 * 分页检索，获取用户信息
	 * 
	 * @param paramMap 检索以及分页参数
	 * @return 信息集合
	 * 
	 * @author HeJiawang
	 * @date   2016.12.08
	 */
	List<Map<String, Object>> pageUserInfo(Map<String, Object> paramMap);

	/**
	 * 按检索条件获取信息条数
	 * 
	 * @param param 检索参数
	 * @return 信息条数
	 * 
	 * @author HeJiawang
	 * @date   2016.12.08
	 */
	Integer pageUserInfoTotal(SoLoveUserDetailInfoParam param);

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param userID 用户ID
	 * @return 用户基本信息
	 */
	SoLoveUserInfoEntity getUserInfoByID(@Param("userID")Integer userID);
}
