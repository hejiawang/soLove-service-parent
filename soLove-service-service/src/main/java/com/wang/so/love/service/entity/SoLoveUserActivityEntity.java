package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 用户——活动 关联表
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveUserActivityEntity implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * userActivityID
	 */
	private Integer userActivityID;

	/**
	 * activityID
	 */
	private Integer activityID;

	/**
	 * userID
	 */
	private Integer userID;

	public Integer getUserActivityID() {
		return userActivityID;
	}

	public void setUserActivityID(Integer userActivityID) {
		this.userActivityID = userActivityID;
	}

	public Integer getActivityID() {
		return activityID;
	}

	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
}
