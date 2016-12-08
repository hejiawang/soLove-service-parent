package com.wang.so.love.service.param;

import java.io.Serializable;

/**
 * 注册会员信息
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
public class SoLoveMemberInfoParam implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * memberID
	 */
	private Integer memberID;

	/**
	 * 所属用户ID
	 */
	private Integer userID;

	/**
	 * 会员等级,默认1级,级数越高权限越大
	 */
	private Integer memberLevel;

	/**
	 * 会员费
	 */
	private Integer memberMoney;

	/**
	 * 会员开启日期
	 */
	private String beginDate;

	/**
	 * 会员结束日期
	 */
	private String endDate;

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(Integer memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Integer getMemberMoney() {
		return memberMoney;
	}

	public void setMemberMoney(Integer memberMoney) {
		this.memberMoney = memberMoney;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
