package com.wang.so.love.service.service;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.so.love.service.param.SoLoveMessageParam;
import com.wang.so.love.service.vo.SoLoveMessageVO;

/**
 * 消息service
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
public interface SoLoveMessageService {
	
	/**
	 * 分页获取消息信息
	 * @param message 查询参数
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 */
	public ServiceResult<Map<String,Object>> pageMessage(SoLoveMessageParam message, Integer start, Integer length, Integer draw);
	
	/**
	 * 新增(发送)消息
	 * @param message 消息
	 * @return
	 */
	public ServiceResult<Void> addMessage( SoLoveMessageParam message );
	
	/**
	 * 修改消息
	 * @param message 消息
	 * @return
	 */
	public ServiceResult<Void> updateMessage( SoLoveMessageParam message );
	
	/**
	 * 删除消息
	 * @param messageID 消息ID
	 * @return
	 */
	public ServiceResult<Void> deleteMessage( Integer messageID );
	
	/**
	 * 根据消息ID获取消息
	 * @param messageID 消息ID
	 * @return
	 */
	public ServiceResult<SoLoveMessageVO> getMessageByID(Integer messageID);
	
	/**
	 * 根据发送者ID获取该用户发送过的消息集合
	 * @param sendUserID 发送者ID
	 * @return
	 */
	public ServiceResult<List<SoLoveMessageVO>> getMessageBySendUserID(Integer sendUserID);
	
	/**
	 * 根据接受者ID后去该用户接收到的消息集合
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	public ServiceResult<List<SoLoveMessageVO>> getMessageByReceiveUserID(Integer receiveUserID);
	
	/**
	 * 获取接收者没有查看的消息个数
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	public ServiceResult<Integer> getNotLookCountByReceiveUserID(Integer receiveUserID);
	
	/**
	 * 设置消息阅读状态
	 * @param messageID 消息ID 
	 * @param isLook 是否阅读过该消息,yes——已读,no——未读,
	 * @return
	 */
	public ServiceResult<Void> setMessageLook(Integer messageID, String isLook);
	
	/**
	 * 设置消息审核状态
	 * @param messageID 消息ID 
	 * @param isLook 审核是否通过,yes——通过,no——未通过,
	 * @return
	 */
	public ServiceResult<Void> setMessageAudit(Integer messageID, String isAudit);
}
