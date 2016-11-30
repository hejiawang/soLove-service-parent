package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 注册用户信息
 * 
 * @author HeJiawang
 * @date   2016.11.30
 */
public class SoLoveUserInfoEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private Integer	userID;
	
	/**
	 * 用户真实姓名
	 */
	private String	userName;
	
	/**
	 * 用户昵称
	 */
	private String	userNick;
	
	/**
	 * 登录名称(手机号)
	 */
	private String	loginName;
	
	/**
	 * 登录密码
	 */
	private String	passWord;
	
	/**
	 * 用户等级</br>
	 * general	:	普通注册用户(默认)</br>
	 * member	:	会员用户</br>
	 */
	private String	userLevel;
	
	/**
	 * 是否删除</br>
	 * yes	:	已删除</br>
	 * no	:	未删除(默认)</br>
	 */
	private String isDelete;
	
	/**
	 * 当前状态</br>
	 * normal	:	正常(默认)</br>
	 * pause	:	暂停</br>
	 */
	private String isCurrent;
	
	

}
