package com.wang.so.love.service.dao.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.so.love.service.param.SoLoveMessageParam;
import com.wang.so.love.service.vo.SoLoveMessageVO;

/**
 * 消息——读
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@MyBatisRepository
public interface SoLoveMessageReadDao {

	/**
	 * 分页获取消息
	 * @param paramMap 查询信息
	 * @return
	 */
	List<Map<String, Object>> pageMessage(Map<String, Object> paramMap);

	/**
	 * 获取分页条数
	 * @param message 查询信息
	 * @return
	 */
	Integer pageMessageTotal(SoLoveMessageParam message);

	/**
	 * 根据消息ID获取消息
	 * @param messageID 消息ID
	 * @return
	 */
	SoLoveMessageVO getMessageByID(@Param("messageID")Integer messageID);

	/**
	 * 根据发送者ID获取该用户发送过的消息集合
	 * @param sendUserID 发送者ID
	 * @return
	 */
	List<SoLoveMessageVO> getMessageBySendUserID(@Param("sendUserID")Integer sendUserID);

	/**
	 * 根据接受者ID后去该用户接收到的消息集合
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	List<SoLoveMessageVO> getMessageByReceiveUserID(@Param("receiveUserID")Integer receiveUserID);

	/**
	 * 获取接收者没有查看的消息个数
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	Integer getNotLookCountByReceiveUserID(@Param("receiveUserID")Integer receiveUserID);

}
