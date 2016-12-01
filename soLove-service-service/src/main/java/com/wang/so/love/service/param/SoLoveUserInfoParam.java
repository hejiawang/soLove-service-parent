package com.wang.so.love.service.param;

import java.io.Serializable;

/**
 * 用户信息参数
 * 
 * @author HeJiawang
 * @date 2016.12.01
 */
public class SoLoveUserInfoParam implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private Integer	userID;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
}
