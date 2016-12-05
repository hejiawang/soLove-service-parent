package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 婚介所工作人员与会员关联关系
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveMaritalMemberEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * maritalMemberID
	 */
	private Integer maritalMemberID;

	/**
	 * 所属婚介所工作人员ID
	 */
	private Integer maritalEmployID;

	/**
	 * 会员ID
	 */
	private Integer memberID;

	public Integer getMaritalMemberID() {
		return maritalMemberID;
	}

	public void setMaritalMemberID(Integer maritalMemberID) {
		this.maritalMemberID = maritalMemberID;
	}

	public Integer getMaritalEmployID() {
		return maritalEmployID;
	}

	public void setMaritalEmployID(Integer maritalEmployID) {
		this.maritalEmployID = maritalEmployID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	
}
