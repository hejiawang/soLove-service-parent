package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 用户——兴趣爱好  关联信息
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveUserHobbyEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * userHobbyID
	 */
	private Integer userHobbyID;

	/**
	 * hobbyID
	 */
	private Integer hobbyID;

	/**
	 * userID
	 */
	private Integer userID;

	public Integer getUserHobbyID() {
		return userHobbyID;
	}

	public void setUserHobbyID(Integer userHobbyID) {
		this.userHobbyID = userHobbyID;
	}

	public Integer getHobbyID() {
		return hobbyID;
	}

	public void setHobbyID(Integer hobbyID) {
		this.hobbyID = hobbyID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
