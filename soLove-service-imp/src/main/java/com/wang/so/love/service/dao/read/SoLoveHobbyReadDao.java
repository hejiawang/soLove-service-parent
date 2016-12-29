package com.wang.so.love.service.dao.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.param.SoLoveHobbyParam;

/**
 * 兴趣爱好——读
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@MyBatisRepository
public interface SoLoveHobbyReadDao {

	/**
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 兴趣爱好
	 */
	SoLoveHobbyEntity getHobbyByID(@Param("hobbyID")Integer hobbyID);

	/**
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 * @return 兴趣爱好集合
	 */
	List<SoLoveHobbyEntity> getHobbyByUserID(@Param("userID")Integer userID);

	/**
	 * 获取所有兴趣爱好
	 * 
	 * @author HeJiawang
	 * @date  2016.12.27
	 */
	List<SoLoveHobbyEntity> getAllHobby();

	/**
	 * 分页获取兴趣爱好
	 * 
	 * @param paramMap 查询map
	 * @return
	 * 
	 * @author HeJiawang
	 * @date  2016.12.29
	 */
	List<Map<String, Object>> pageHobby(Map<String, Object> paramMap);

	/**
	 * 获取兴趣爱好分页条数
	 * 
	 * @param paramMap 查询map
	 * @return
	 * 
	 * @author HeJiawang
	 * @date  2016.12.29
	 */
	Integer pageHobbyTotal(SoLoveHobbyParam param);

	/**
	 * 获取兴趣爱好信息树
	 * 
	 * @param parentHobbyID 父兴趣爱好ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date  2016.12.29
	 */
	List<SoLoveHobbyParam> getHobbyTreeData(@Param("parentHobbyID")Integer parentHobbyID);

}
