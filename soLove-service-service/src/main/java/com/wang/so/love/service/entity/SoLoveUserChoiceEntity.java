package com.wang.so.love.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户有权限查看的信息
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveUserChoiceEntity implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * userChoiceID
	 */
	private Integer userChoiceID;

	/**
	 * 所属用户ID
	 */
	private Integer userID;

	/**
	 * 有权限查看的用户ID
	 */
	private Integer choiceUserID;

	/**
	 * 是否有意向(是否点赞), yes:是 no:否(默认)
	 */
	private String setChoice;

	/**
	 * 是否获得对方意向(是否获得回赞), yes:是 no:否(默认)
	 */
	private String getChoice;

	/**
	 * 有权限查看的开始日期
	 */
	private Date choiceDate;

	public Integer getUserChoiceID() {
		return userChoiceID;
	}

	public void setUserChoiceID(Integer userChoiceID) {
		this.userChoiceID = userChoiceID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getChoiceUserID() {
		return choiceUserID;
	}

	public void setChoiceUserID(Integer choiceUserID) {
		this.choiceUserID = choiceUserID;
	}

	public String getSetChoice() {
		return setChoice;
	}

	public void setSetChoice(String setChoice) {
		this.setChoice = setChoice;
	}

	public String getGetChoice() {
		return getChoice;
	}

	public void setGetChoice(String getChoice) {
		this.getChoice = getChoice;
	}

	public Date getChoiceDate() {
		return choiceDate;
	}

	public void setChoiceDate(Date choiceDate) {
		this.choiceDate = choiceDate;
	}
	
}
