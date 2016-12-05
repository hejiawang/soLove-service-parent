package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 婚介所工作人员
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveMaritalEmployEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * maritalEmployID
	 */
	private Integer maritalEmployID;

	/**
	 * 所属婚介所ID
	 */
	private Integer maritalAgencyID;

	/**
	 * 性别, man:男 woman:女
	 */
	private String maritalEmploySex;

	/**
	 * 年龄
	 */
	private Integer maritalEmployAge;

	/**
	 * 真实姓名
	 */
	private String maritalEmployName;

	/**
	 * 昵称
	 */
	private String maritalEmployNick;

	/**
	 * 联系电话
	 */
	private String maritalEmployPhone;

	/**
	 * QQ
	 */
	private String maritalEmployQQ;

	/**
	 * 微信
	 */
	private String maritalEmployWeixin;

	/**
	 * 头像
	 */
	private String maritalEmployImage;

	/**
	 * 自我评价:促使多少新人在一起等等
	 */
	private String maritalEmployEvaluation;

	/**
	 * 排序
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

	/**
	 * 备注
	 */
	private String theNode;

	public Integer getMaritalEmployID() {
		return maritalEmployID;
	}

	public void setMaritalEmployID(Integer maritalEmployID) {
		this.maritalEmployID = maritalEmployID;
	}

	public Integer getMaritalAgencyID() {
		return maritalAgencyID;
	}

	public void setMaritalAgencyID(Integer maritalAgencyID) {
		this.maritalAgencyID = maritalAgencyID;
	}

	public String getMaritalEmploySex() {
		return maritalEmploySex;
	}

	public void setMaritalEmploySex(String maritalEmploySex) {
		this.maritalEmploySex = maritalEmploySex;
	}

	public Integer getMaritalEmployAge() {
		return maritalEmployAge;
	}

	public void setMaritalEmployAge(Integer maritalEmployAge) {
		this.maritalEmployAge = maritalEmployAge;
	}

	public String getMaritalEmployName() {
		return maritalEmployName;
	}

	public void setMaritalEmployName(String maritalEmployName) {
		this.maritalEmployName = maritalEmployName;
	}

	public String getMaritalEmployNick() {
		return maritalEmployNick;
	}

	public void setMaritalEmployNick(String maritalEmployNick) {
		this.maritalEmployNick = maritalEmployNick;
	}

	public String getMaritalEmployPhone() {
		return maritalEmployPhone;
	}

	public void setMaritalEmployPhone(String maritalEmployPhone) {
		this.maritalEmployPhone = maritalEmployPhone;
	}

	public String getMaritalEmployQQ() {
		return maritalEmployQQ;
	}

	public void setMaritalEmployQQ(String maritalEmployQQ) {
		this.maritalEmployQQ = maritalEmployQQ;
	}

	public String getMaritalEmployWeixin() {
		return maritalEmployWeixin;
	}

	public void setMaritalEmployWeixin(String maritalEmployWeixin) {
		this.maritalEmployWeixin = maritalEmployWeixin;
	}

	public String getMaritalEmployImage() {
		return maritalEmployImage;
	}

	public void setMaritalEmployImage(String maritalEmployImage) {
		this.maritalEmployImage = maritalEmployImage;
	}

	public String getMaritalEmployEvaluation() {
		return maritalEmployEvaluation;
	}

	public void setMaritalEmployEvaluation(String maritalEmployEvaluation) {
		this.maritalEmployEvaluation = maritalEmployEvaluation;
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

	public String getTheNode() {
		return theNode;
	}

	public void setTheNode(String theNode) {
		this.theNode = theNode;
	}
	
}
