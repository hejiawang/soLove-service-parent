package com.wang.so.love.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveActivityEntity implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * activityID
	 */
	private Integer activityID;

	/**
	 * 参加活动金额
	 */
	private Integer activityMoney;

	/**
	 * 活动开始时间
	 */
	private Date activityStartTime;

	/**
	 * 活动结束时间
	 */
	private Date activityEndTime;

	/**
	 * 活动内容
	 */
	private String activityContent;

	/**
	 * 排序,默认1
	 */
	private Integer sort;

	/**
	 * 当前状态, normal:正常(默认) pause:暂停
	 */
	private String isCurrent;

	/**
	 * 是否删除, yes:已删除 no:未删除(默认)
	 */
	private String isDelete;

	public Integer getActivityID() {
		return activityID;
	}

	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	public Integer getActivityMoney() {
		return activityMoney;
	}

	public void setActivityMoney(Integer activityMoney) {
		this.activityMoney = activityMoney;
	}

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(String isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

}
