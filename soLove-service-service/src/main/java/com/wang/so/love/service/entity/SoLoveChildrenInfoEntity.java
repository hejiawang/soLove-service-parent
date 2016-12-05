package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 用户子女信息
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveChildrenInfoEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * childrenID
	 */
	private Integer childrenID;

	/**
	 * 所属用户ID
	 */
	private Integer userID;

	/**
	 * 关系, man:儿子 woman:女儿
	 */
	private String childrenRelation;

	/**
	 * 年龄
	 */
	private Integer childrenAge;

	/**
	 * 简介 如：上学情况、工作情况、婚姻情况、住房情况、健康情况
	 */
	private String childrenRecommend;

	public Integer getChildrenID() {
		return childrenID;
	}

	public void setChildrenID(Integer childrenID) {
		this.childrenID = childrenID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getChildrenRelation() {
		return childrenRelation;
	}

	public void setChildrenRelation(String childrenRelation) {
		this.childrenRelation = childrenRelation;
	}

	public Integer getChildrenAge() {
		return childrenAge;
	}

	public void setChildrenAge(Integer childrenAge) {
		this.childrenAge = childrenAge;
	}

	public String getChildrenRecommend() {
		return childrenRecommend;
	}

	public void setChildrenRecommend(String childrenRecommend) {
		this.childrenRecommend = childrenRecommend;
	}
	
}
