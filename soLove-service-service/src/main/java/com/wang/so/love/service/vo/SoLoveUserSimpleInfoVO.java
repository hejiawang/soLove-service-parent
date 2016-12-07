package com.wang.so.love.service.vo;

import java.io.Serializable;

/**
 * 信息列表页中显示的用户简单信息</br>
 * 如：年龄、爱好等
 * 
 * @author HeJiawang
 * @date   2016.12.07
 */
public class SoLoveUserSimpleInfoVO implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private Integer	userID;
	
	/**
	 * 年龄
	 */
	private Integer userAge;
	
	/**
	 * 性别, man:男 woman:女
	 */
	private String userSex;
	
	/**
	 * 用户头像
	 */
	private String userHeadImage;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserHeadImage() {
		return userHeadImage;
	}

	public void setUserHeadImage(String userHeadImage) {
		this.userHeadImage = userHeadImage;
	}
	
}
