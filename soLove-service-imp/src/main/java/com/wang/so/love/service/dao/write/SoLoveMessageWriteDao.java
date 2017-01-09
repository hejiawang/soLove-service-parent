package com.wang.so.love.service.dao.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMessageParam;

/**
 * 消息——写
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@MyBatisRepository
public interface SoLoveMessageWriteDao {

	/**
	 * 新增(发送)消息
	 * @param message 消息
	 * @return
	 */
	Integer addMessage(SoLoveMessageParam message);

	/**
	 * 修改消息
	 * @param message 消息
	 * @return
	 */
	Integer updateMessage(SoLoveMessageParam message);

	/**
	 * 删除消息
	 * @param messageID 消息ID
	 * @return
	 */
	Integer deleteMessage(@Param("messageID")Integer messageID);

	/**
	 * 设置消息阅读状态
	 * @param messageID 消息ID 
	 * @param isLook 是否阅读过该消息,yes——已读,no——未读,
	 * @return
	 */
	Integer setMessageLook(@Param("messageID")Integer messageID, @Param("isLook")String isLook);

	/**
	 * 设置消息审核状态
	 * @param messageID 消息ID 
	 * @param isLook 审核是否通过,yes——通过,no——未通过,
	 * @return
	 */
	Integer setMessageAudit(@Param("messageID")Integer messageID, @Param("isAudit")String isAudit);

}
