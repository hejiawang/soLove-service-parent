package com.wang.so.love.service.vo;

import java.io.Serializable;

/**
 * 婚介所工作人员
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
public class SoLoveMaritalEmployVO implements Serializable {

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

	/**
	 * 婚介所名称
	 */
	private String maritalAgencyName;

	/**
	 * 婚介所logo
	 */
	private String maritalAgencyLogo;

	/**
	 * 婚介所联系方式
	 */
	private String maritalAgencyPhone;

	/**
	 * 婚介所描述(详细信息)
	 */
	private String maritalAgencyDetail;

	/**
	 * 婚介所地址——省ID
	 */
	private Integer provinceID;

	/**
	 * 婚介所地址——省名称
	 */
	private String provinceName;

	/**
	 * 婚介所地址——市ID
	 */
	private Integer cityID;

	/**
	 * 婚介所地址——市名称
	 */
	private String cityName;

	/**
	 * 婚介所地址——区县ID
	 */
	private Integer countyID;

	/**
	 * 婚介所地址——区县名称
	 */
	private String countyName;

	/**
	 * 婚介所地址——村ID
	 */
	private Integer townID;

	/**
	 * 婚介所地址——村名称
	 */
	private String townName;

	/**
	 * 婚介所地址——详细地址
	 */
	private String areaName;
	
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

	public String getMaritalAgencyName() {
		return maritalAgencyName;
	}

	public void setMaritalAgencyName(String maritalAgencyName) {
		this.maritalAgencyName = maritalAgencyName;
	}

	public String getMaritalAgencyLogo() {
		return maritalAgencyLogo;
	}

	public void setMaritalAgencyLogo(String maritalAgencyLogo) {
		this.maritalAgencyLogo = maritalAgencyLogo;
	}

	public String getMaritalAgencyPhone() {
		return maritalAgencyPhone;
	}

	public void setMaritalAgencyPhone(String maritalAgencyPhone) {
		this.maritalAgencyPhone = maritalAgencyPhone;
	}

	public String getMaritalAgencyDetail() {
		return maritalAgencyDetail;
	}

	public void setMaritalAgencyDetail(String maritalAgencyDetail) {
		this.maritalAgencyDetail = maritalAgencyDetail;
	}

	public Integer getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCountyID() {
		return countyID;
	}

	public void setCountyID(Integer countyID) {
		this.countyID = countyID;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Integer getTownID() {
		return townID;
	}

	public void setTownID(Integer townID) {
		this.townID = townID;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}
