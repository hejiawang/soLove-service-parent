package com.wang.so.love.service.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
public class SoLoveMessageVO implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息ID
	 */
	private Integer messageID;
	
	/**
	 * 当前状态, normal:正常(默认) pause:暂停
	 */
	private String isCurrent;
	
	/**
	 * 是否删除, yes:已删除  no:未删除(默认)
	 */
	private String isDelete;
	
	/**
	 * 发送者ID
	 */
	private Integer sendUserID;
	
	/**
	 * 发送者昵称
	 */
	private String sendUserNick;
	
	/**
	 * 发送者姓名
	 */
	private String sendUserName;
	
	/**
	 * 接收者ID
	 */
	private Integer receiveUserID;
	
	/**
	 * 接受者昵称
	 */
	private String receiveUserNick;
	
	/**
	 * 接收者姓名
	 */
	private String receiveUserName;
	
	/**
	 * 消息内容
	 */
	private String messageContent;
	
	/**
	 * 消息发送时间
	 */
	private Date creatTime;
	
	/**
	 * 是否查看, yes:已查看  no:未查看(默认)
	 */
	private String isLook;
	
	/**
	 * 是否审核, yes:已审核  no:未审核(默认)
	 */
	private String isAudit;
	
	/**
	 * 备注
	 */
	private String theNode;

	public Integer getMessageID() {
		return messageID;
	}

	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
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

	public Integer getSendUserID() {
		return sendUserID;
	}

	public void setSendUserID(Integer sendUserID) {
		this.sendUserID = sendUserID;
	}

	public Integer getReceiveUserID() {
		return receiveUserID;
	}

	public void setReceiveUserID(Integer receiveUserID) {
		this.receiveUserID = receiveUserID;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getIsLook() {
		return isLook;
	}

	public void setIsLook(String isLook) {
		this.isLook = isLook;
	}

	public String getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(String isAudit) {
		this.isAudit = isAudit;
	}

	public String getTheNode() {
		return theNode;
	}

	public void setTheNode(String theNode) {
		this.theNode = theNode;
	}

	public String getSendUserNick() {
		return sendUserNick;
	}

	public void setSendUserNick(String sendUserNick) {
		this.sendUserNick = sendUserNick;
	}

	public String getReceiveUserNick() {
		return receiveUserNick;
	}

	public void setReceiveUserNick(String receiveUserNick) {
		this.receiveUserNick = receiveUserNick;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getReceiveUserName() {
		return receiveUserName;
	}

	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}
	
}
