package com.wang.so.love.service.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 注册用户信息
 * 
 * @author HeJiawang
 * @date   2016.11.30
 */
public class SoLoveUserInfoEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private Integer	userID;
	
	/**
	 * 获赞数</br>
	 * (有几个人对我有意向)
	 */
	private Integer	getChoiceNum;
	
	/**
	 * 点赞数</br>
	 * (对几个人有意向)
	 */
	private Integer	setChoiceNum;
	
	/**
	 * 积分总和
	 */
	private Integer	userIntegralTotal;
	
	/**
	 * 一共可查看多少信息
	 */
	private Integer	userChoiceTotal;
	
	/**
	 * 已经查看多少信息
	 */
	private Integer	userChoiceNum;
	
	/**
	 * 是否脱单成功</br>
	 * no  : 否(默认)</br>   
	 * yes : 是
	 */
	private String	userMaritalSuccess;
	
	/**
	 * 注册普通用户日期
	 */
	private Date	registerDate;
	
	/**
	 * 用户注册方式</br>
	 * web(默认)、android、ios
	 */
	private String	registerType;
	
	/**
	 * 登录名称(手机号)
	 */
	private String	loginName;
	
	/**
	 * 登录密码
	 */
	private String	passWord;
	
	/**
	 * 用户等级</br>
	 * general	:	普通注册用户(默认)</br>
	 * member	:	会员用户</br>
	 */
	private String	userLevel;
	
	/**
	 * 是否删除</br>
	 * yes	:	已删除</br>
	 * no	:	未删除(默认)</br>
	 */
	private String isDelete;
	
	/**
	 * 当前状态</br>
	 * normal	:	正常(默认)</br>
	 * pause	:	暂停</br>
	 */
	private String isCurrent;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getGetChoiceNum() {
		return getChoiceNum;
	}

	public void setGetChoiceNum(Integer getChoiceNum) {
		this.getChoiceNum = getChoiceNum;
	}

	public Integer getSetChoiceNum() {
		return setChoiceNum;
	}

	public void setSetChoiceNum(Integer setChoiceNum) {
		this.setChoiceNum = setChoiceNum;
	}

	public Integer getUserIntegralTotal() {
		return userIntegralTotal;
	}

	public void setUserIntegralTotal(Integer userIntegralTotal) {
		this.userIntegralTotal = userIntegralTotal;
	}

	public Integer getUserChoiceTotal() {
		return userChoiceTotal;
	}

	public void setUserChoiceTotal(Integer userChoiceTotal) {
		this.userChoiceTotal = userChoiceTotal;
	}

	public Integer getUserChoiceNum() {
		return userChoiceNum;
	}

	public void setUserChoiceNum(Integer userChoiceNum) {
		this.userChoiceNum = userChoiceNum;
	}

	public String getUserMaritalSuccess() {
		return userMaritalSuccess;
	}

	public void setUserMaritalSuccess(String userMaritalSuccess) {
		this.userMaritalSuccess = userMaritalSuccess;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(String isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	
}
