package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * APP设置
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveAppSettingEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * appSettingID
	 */
	private Integer appSettingID;
	
	/**
	 * APP版本
	 */
	private Integer appVersion;

	public Integer getAppSettingID() {
		return appSettingID;
	}

	public void setAppSettingID(Integer appSettingID) {
		this.appSettingID = appSettingID;
	}

	public Integer getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(Integer appVersion) {
		this.appVersion = appVersion;
	}
	
}
