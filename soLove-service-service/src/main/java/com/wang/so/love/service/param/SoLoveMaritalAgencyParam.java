package com.wang.so.love.service.param;

import java.io.Serializable;

/**
 * 婚介所
 * 
 * @author HeJiawang
 * @date 2016.12.09
 */
public class SoLoveMaritalAgencyParam implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * maritalAgencyID
	 */
	private Integer maritalAgencyID;

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
	 * 省ID
	 */
	private Integer provinceID;

	/**
	 * 省名称
	 */
	private String provinceName;

	/**
	 * 市ID
	 */
	private Integer cityID;

	/**
	 * 市名称
	 */
	private String cityName;

	/**
	 * 区县ID
	 */
	private Integer countyID;

	/**
	 * 区县名称
	 */
	private String countyName;

	/**
	 * 村ID
	 */
	private Integer townID;

	/**
	 * 村名称
	 */
	private String townName;

	/**
	 * 详细地址
	 */
	private String areaName;

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

	public Integer getMaritalAgencyID() {
		return maritalAgencyID;
	}

	public void setMaritalAgencyID(Integer maritalAgencyID) {
		this.maritalAgencyID = maritalAgencyID;
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
