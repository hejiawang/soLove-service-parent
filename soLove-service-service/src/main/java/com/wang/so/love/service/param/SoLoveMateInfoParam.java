package com.wang.so.love.service.param;

import java.io.Serializable;

/**
 * 择偶信息
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveMateInfoParam implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mateID
	 */
	private Integer mateID;

	/**
	 * 所属用户ID
	 */
	private Integer userID;

	/**
	 * 性别, man:男 woman:女
	 */
	private String mateSex;

	/**
	 * 年龄 0:-25 1:25-30 2:30-35 3:35-40 4:40-50 5:50+
	 */
	private Integer mateAgeLevel;
	private Integer mateAgeLow;		//对应mateAgeLevel的最低值
	private Integer mateAgeHigh;	//对应mateAgeLevel的最高值
	
	/**
	 * 身高 0:-160 1:160-165 2:165-170 3:170-175 4:175-180 5:180+
	 */
	private Integer mateHeightLevel;
	private Integer mateHeightLow;	//对应mateHeightLevel的最低值
	private Integer mateHeightHigh;	//对应mateHeightLevel的最高值
	

	/**
	 * 学历 0无、1小学、2初中、3高中、4大专、5专科、6本科、7硕士、8博士
	 */
	private Integer mateEducation;

	/**
	 * 月收入范围 0:2000及以下 1:2001——10000 2:10000及以上
	 */
	private Integer mateIncomeLevel;

	/**
	 * 婚姻状况 unmarried:未婚(默认) remarried:离异
	 */
	private String mateMaritalStatus;

	/**
	 * 购车情况 no:没车(默认) yes:有车
	 */
	private String mateHaveCar;

	/**
	 * 购房情况 no:没房(默认) yes:有房
	 */
	private String mateHaveHome;

	/**
	 * 是否有子女 no:没有(默认) yes:有
	 */
	private String mateHaveChildren;

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
	 * 备注
	 */
	private String theNode;
	
	/**
	 * 分页——起始
	 */
	private Integer limitStart;
	
	/**
	 * 分页——取多少条
	 */
	private Integer limitLength;

	public Integer getMateID() {
		return mateID;
	}

	public void setMateID(Integer mateID) {
		this.mateID = mateID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getMateSex() {
		return mateSex;
	}

	public void setMateSex(String mateSex) {
		this.mateSex = mateSex;
	}

	public Integer getMateAgeLevel() {
		return mateAgeLevel;
	}

	public void setMateAgeLevel(Integer mateAgeLevel) {
		this.mateAgeLevel = mateAgeLevel;
	}

	public Integer getMateHeightLevel() {
		return mateHeightLevel;
	}

	public void setMateHeightLevel(Integer mateHeightLevel) {
		this.mateHeightLevel = mateHeightLevel;
	}

	public Integer getMateEducation() {
		return mateEducation;
	}

	public void setMateEducation(Integer mateEducation) {
		this.mateEducation = mateEducation;
	}

	public Integer getMateIncomeLevel() {
		return mateIncomeLevel;
	}

	public void setMateIncomeLevel(Integer mateIncomeLevel) {
		this.mateIncomeLevel = mateIncomeLevel;
	}

	public String getMateMaritalStatus() {
		return mateMaritalStatus;
	}

	public void setMateMaritalStatus(String mateMaritalStatus) {
		this.mateMaritalStatus = mateMaritalStatus;
	}

	public String getMateHaveCar() {
		return mateHaveCar;
	}

	public void setMateHaveCar(String mateHaveCar) {
		this.mateHaveCar = mateHaveCar;
	}

	public String getMateHaveHome() {
		return mateHaveHome;
	}

	public void setMateHaveHome(String mateHaveHome) {
		this.mateHaveHome = mateHaveHome;
	}

	public String getMateHaveChildren() {
		return mateHaveChildren;
	}

	public void setMateHaveChildren(String mateHaveChildren) {
		this.mateHaveChildren = mateHaveChildren;
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

	public String getTheNode() {
		return theNode;
	}

	public void setTheNode(String theNode) {
		this.theNode = theNode;
	}

	public Integer getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(Integer limitStart) {
		this.limitStart = limitStart;
	}

	public Integer getLimitLength() {
		return limitLength;
	}

	public void setLimitLength(Integer limitLength) {
		this.limitLength = limitLength;
	}

	public Integer getMateAgeLow() {
		return mateAgeLow;
	}

	public void setMateAgeLow(Integer mateAgeLow) {
		this.mateAgeLow = mateAgeLow;
	}

	public Integer getMateAgeHigh() {
		return mateAgeHigh;
	}

	public void setMateAgeHigh(Integer mateAgeHigh) {
		this.mateAgeHigh = mateAgeHigh;
	}

	public Integer getMateHeightLow() {
		return mateHeightLow;
	}

	public void setMateHeightLow(Integer mateHeightLow) {
		this.mateHeightLow = mateHeightLow;
	}

	public Integer getMateHeightHigh() {
		return mateHeightHigh;
	}

	public void setMateHeightHigh(Integer mateHeightHigh) {
		this.mateHeightHigh = mateHeightHigh;
	}
	
}
