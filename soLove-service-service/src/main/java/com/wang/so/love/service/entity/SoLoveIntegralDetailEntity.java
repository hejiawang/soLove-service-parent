package com.wang.so.love.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分详细
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveIntegralDetailEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * integralDetailID
	 */
	private Integer integralDetailID;

	/**
	 * 用户ID
	 */
	private Integer userID;

	/**
	 * 积分明细方式, add:增加(默认) reduce:减少
	 */
	private String integralMode;

	/**
	 * 积分明细内容
	 */
	private String integralContent;

	/**
	 * 积分明细时间
	 */
	private Date integralTime;

	public Integer getIntegralDetailID() {
		return integralDetailID;
	}

	public void setIntegralDetailID(Integer integralDetailID) {
		this.integralDetailID = integralDetailID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getIntegralMode() {
		return integralMode;
	}

	public void setIntegralMode(String integralMode) {
		this.integralMode = integralMode;
	}

	public String getIntegralContent() {
		return integralContent;
	}

	public void setIntegralContent(String integralContent) {
		this.integralContent = integralContent;
	}

	public Date getIntegralTime() {
		return integralTime;
	}

	public void setIntegralTime(Date integralTime) {
		this.integralTime = integralTime;
	}

}
