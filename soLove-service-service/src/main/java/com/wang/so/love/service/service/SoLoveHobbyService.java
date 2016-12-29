package com.wang.so.love.service.service;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.param.SoLoveHobbyParam;

/**
 * 兴趣爱好接口
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
public interface SoLoveHobbyService {

	/**
	 * 新增兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 */
	public ServiceResult<Void> addHobby( SoLoveHobbyParam hobby );

	/**
	 * 修改兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 */
	public ServiceResult<Void> modifyHobby( SoLoveHobbyParam hobby );
	
	/**
	 * 删除兴趣爱好
	 * 
	 * @param hobbyID 兴趣爱好ID
	 */
	public ServiceResult<Void> deleteHobby( Integer hobbyID );
	
	/**
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 */
	public ServiceResult<SoLoveHobbyEntity> getHobbyByID( Integer hobbyID );
	
	/**
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 */
	public ServiceResult<List<SoLoveHobbyEntity>> getHobbyByUserID( Integer userID );
	
	/**
	 * 获取所有兴趣爱好
	 * 
	 * @author HeJiawang
	 * @date  2016.12.27
	 */
	public ServiceResult<List<SoLoveHobbyEntity>> getAllHobby();

	/**
	 * 用户兴趣爱好维护
	 * 
	 * @param hobbyIDs 兴趣爱好ID集合
	 * @param userID 用户ID
	 * 
	 * @author HeJiawang
	 * @date  2016.12.27
	 */
	public ServiceResult<Void> modifyUserHobby(Integer userID, List<Integer> hobbyIDs);

	/**
	 * 分页获取兴趣爱好信息
	 * 
	 * @param param 查询信息
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Map<String,Object>> pageHobby(SoLoveHobbyParam param, Integer start, Integer length, Integer draw);

	/**
	 * 获取兴趣爱好树
	 * 
	 * @param id 父兴趣爱好ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<List<SoLoveHobbyParam>> getHobbyTreeData(Integer parentID);
}
