package com.wang.so.love.service.entity;

import java.io.Serializable;

/**
 * 兴趣爱好
 * 
 * @author HeJiawang
 * @date 2016.12.05
 */
public class SoLoveHobbyEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * hobbyID
	 */
	private Integer hobbyID;

	/**
	 * 父hobbyID
	 */
	private Integer parentHobbyID;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 排序(默认1)
	 */
	private Integer sort;

	/**
	 * 是否为父hobby, yes:是 no:否(默认)
	 */
	private String isParent;

	/**
	 * 当前状态, normal:正常(默认) pause:暂停
	 */
	private String isCurrent;

	/**
	 * 是否删除, yes:已删除 no:未删除(默认)
	 */
	private String isDelete;

	public Integer getHobbyID() {
		return hobbyID;
	}

	public void setHobbyID(Integer hobbyID) {
		this.hobbyID = hobbyID;
	}

	public Integer getParentHobbyID() {
		return parentHobbyID;
	}

	public void setParentHobbyID(Integer parentHobbyID) {
		this.parentHobbyID = parentHobbyID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
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
	
}
