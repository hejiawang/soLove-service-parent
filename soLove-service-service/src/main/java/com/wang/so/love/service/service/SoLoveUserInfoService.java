package com.wang.so.love.service.service;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
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
}
