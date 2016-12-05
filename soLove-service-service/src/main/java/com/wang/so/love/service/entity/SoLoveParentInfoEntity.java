package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 用户父母信息
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveParentInfoEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * parentID
	 */
	private Integer parentID;

	/**
	 * 所属用户ID
	 */
	private Integer userID;

	/**
	 * 关系, man:父亲   woman:母亲
	 */
	private String parentRelation;

	/**
	 * 年龄
	 */
	private Integer parentAge;

	/**
	 * 简介 如：上学情况、工作情况、婚姻情况、住房情况、健康情况
	 */
	private String parentRecommend;

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getParentRelation() {
		return parentRelation;
	}

	public void setParentRelation(String parentRelation) {
		this.parentRelation = parentRelation;
	}

	public Integer getParentAge() {
		return parentAge;
	}

	public void setParentAge(Integer parentAge) {
		this.parentAge = parentAge;
	}

	public String getParentRecommend() {
		return parentRecommend;
	}

	public void setParentRecommend(String parentRecommend) {
		this.parentRecommend = parentRecommend;
	}
	
}
