package com.wang.so.love.service.param;

import java.io.Serializable;

/**
 * 用户详细信息
 * 
 * @author HeJiawang
 * @date   2016.12.05
 */
public class SoLoveUserDetailInfoParam implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * userDetailInfoID
	 */
	private Integer userDetailInfoID;

	/**
	 * 所属用户ID
	 */
	private Integer userID;

	/**
	 * 身份证号
	 */
	private String userCard;

	/**
	 * 性别, man:男 woman:女
	 */
	private String userSex;

	/**
	 * 年龄
	 */
	private Integer userAge;

	/**
	 * 真实姓名
	 */
	private String userName;

	/**
	 * 昵称
	 */
	private String userNick;

	/**
	 * 联系电话
	 */
	private String userPhone;

	/**
	 * QQ
	 */
	private String userQQ;

	/**
	 * 微信
	 */
	private String userWeixin;

	/**
	 * 用户头像
	 */
	private String userHeadImage;

	/**
	 * 民族
	 */
	private String userNation;

	/**
	 * 工作性质、职务职称
	 */
	private String userWork;

	/**
	 * 宗教信仰
	 */
	private String userFaith;

	/**
	 * 血型 A B O AB
	 */
	private String userBlood;

	/**
	 * 身高(cm)
	 */
	private Integer userHeight;

	/**
	 * 体重(公斤)
	 */
	private Integer userWeight;

	/**
	 * 生日
	 */
	private String userBirthday;

	/**
	 * 自我评价
	 */
	private String userEvaluation;

	/**
	 * 爱情规划
	 */
	private String userLovePlan;

	/**
	 * 备注
	 */
	private String theNode;

	/**
	 * 毕业学校
	 */
	private String userSchool;

	/**
	 * 所学专业
	 */
	private String userMagor;

	/**
	 * 学历 0无、1小学、2初中、3高中、4大专、5专科、6本科、7硕士、8博士
	 */
	private Integer userEducation;

	/**
	 * 月收入范围 0:2000及以下 1:2001——10000 2:10000及以上
	 */
	private Integer userIncomeLevel;

	/**
	 * 婚姻状况 unmarried:未婚(默认) remarried:离异
	 */
	private String userMaritalStatus;

	/**
	 * 离婚证号
	 */
	private String userMaritalCard;

	/**
	 * 购车情况 no:没车(默认) yes:有车
	 */
	private String userHaveCar;

	/**
	 * 购房情况 no:没房(默认) yes:有房
	 */
	private String userHaveHome;

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

	public Integer getUserDetailInfoID() {
		return userDetailInfoID;
	}

	public void setUserDetailInfoID(Integer userDetailInfoID) {
		this.userDetailInfoID = userDetailInfoID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public String getUserWeixin() {
		return userWeixin;
	}

	public void setUserWeixin(String userWeixin) {
		this.userWeixin = userWeixin;
	}

	public String getUserHeadImage() {
		return userHeadImage;
	}

	public void setUserHeadImage(String userHeadImage) {
		this.userHeadImage = userHeadImage;
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	public String getUserWork() {
		return userWork;
	}

	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}

	public String getUserFaith() {
		return userFaith;
	}

	public void setUserFaith(String userFaith) {
		this.userFaith = userFaith;
	}

	public String getUserBlood() {
		return userBlood;
	}

	public void setUserBlood(String userBlood) {
		this.userBlood = userBlood;
	}

	public Integer getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(Integer userHeight) {
		this.userHeight = userHeight;
	}

	public Integer getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(Integer userWeight) {
		this.userWeight = userWeight;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserEvaluation() {
		return userEvaluation;
	}

	public void setUserEvaluation(String userEvaluation) {
		this.userEvaluation = userEvaluation;
	}

	public String getUserLovePlan() {
		return userLovePlan;
	}

	public void setUserLovePlan(String userLovePlan) {
		this.userLovePlan = userLovePlan;
	}

	public String getTheNode() {
		return theNode;
	}

	public void setTheNode(String theNode) {
		this.theNode = theNode;
	}

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	public String getUserMagor() {
		return userMagor;
	}

	public void setUserMagor(String userMagor) {
		this.userMagor = userMagor;
	}

	public Integer getUserEducation() {
		return userEducation;
	}

	public void setUserEducation(Integer userEducation) {
		this.userEducation = userEducation;
	}

	public Integer getUserIncomeLevel() {
		return userIncomeLevel;
	}

	public void setUserIncomeLevel(Integer userIncomeLevel) {
		this.userIncomeLevel = userIncomeLevel;
	}

	public String getUserMaritalStatus() {
		return userMaritalStatus;
	}

	public void setUserMaritalStatus(String userMaritalStatus) {
		this.userMaritalStatus = userMaritalStatus;
	}

	public String getUserMaritalCard() {
		return userMaritalCard;
	}

	public void setUserMaritalCard(String userMaritalCard) {
		this.userMaritalCard = userMaritalCard;
	}

	public String getUserHaveCar() {
		return userHaveCar;
	}

	public void setUserHaveCar(String userHaveCar) {
		this.userHaveCar = userHaveCar;
	}

	public String getUserHaveHome() {
		return userHaveHome;
	}

	public void setUserHaveHome(String userHaveHome) {
		this.userHaveHome = userHaveHome;
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
}
