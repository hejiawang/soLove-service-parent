package com.wang.so.love.service.service;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.param.SoLoveUserInfoParam;
import com.wang.so.love.service.vo.SoLoveUserSimpleInfoVO;

/**
 * 用户基本信息接口
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
public interface SoLoveUserInfoService {

	/**
	 * 新增一个普通注册用户</br>
	 * 记录登录手机号、密码、注册方式的信息</br>
	 * 并在详细信息表、照片表、择偶信息表中新建一条与该用户对应的数据</br>
	 * 若要填写详细信息,应进行信息维护</br>
	 * 注意:本方法用户后台添加用户,app注册应调用SoLoveLoginService
	 * 
	 * @param userInfo 用户信息
	 */
	public ServiceResult<Void> addUserInfo(SoLoveUserInfoParam userInfo);
	
	/**
	 * 删除用户
	 * 
	 * @param userID 用户ID
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	public ServiceResult<Void> deleteUserInfo(Integer userID);
	
	/**
	 * 根据用户ID查看用户的信息——详细信息、照片、爱好、子女父母等所有信息 
	 * 
	 * @param userID 用户ID
	 * @return 
	 * 		用户信息Map</br>
	 * 		<li>key:userInfo——用户基本信息</li>
	 * 		<li>key:userDetail——用户详细信息</li>
	 * 		<li>key:userImg——用户照片信息</li>
	 * 		<li>key:userHobby——用户兴趣爱好信息</li>
	 * 		<li>key:userParent——用户父母信息</li>
	 * 		<li>key:userChildren——用户子女信息</li>
	 * 		<li>key:userMate——用户择偶信息</li>
	 *  
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	public ServiceResult<Map<String, Object>> viewUserInfo(Integer userID);
	
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
	public ServiceResult<List<SoLoveUserSimpleInfoVO>> getUserByMateInfo( SoLoveMateInfoParam mateInfo );

	/**
	 * 根据条件搜索用户信息</br>
	 * 并进行分页
	 * 
	 * @param param 检索条件
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * 
	 * @return 适应So love后台管理系统js分页插件的Map
	 * 
	 * @author HeJiawang
	 * @date   2016.12.08
	 */
	public ServiceResult<Map<String,Object>> pageUserInfo(SoLoveUserDetailInfoParam param, Integer start, Integer length, Integer draw);

}
