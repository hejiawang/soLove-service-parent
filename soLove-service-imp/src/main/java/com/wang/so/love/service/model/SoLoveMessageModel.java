package com.wang.so.love.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveMessageReadDao;
import com.wang.so.love.service.dao.write.SoLoveMessageWriteDao;
import com.wang.so.love.service.param.SoLoveMessageParam;
import com.wang.so.love.service.vo.SoLoveMessageVO;

/**
 * 消息 Model
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@Service
public class SoLoveMessageModel {

	/**
	 * soLoveMessageReadDao
	 */
	@Autowired
	private SoLoveMessageReadDao soLoveMessageReadDao;
	
	/**
	 * soLoveMessageWriteDao
	 */
	@Autowired
	private SoLoveMessageWriteDao soLoveMessageWriteDao;
	
	/**
	 * 分页获取消息信息
	 * @param message 查询参数
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 */
	public Map<String, Object> pageMessage(SoLoveMessageParam message, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveMessageReadDao, "Property 'soLoveMessageReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");;
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "message", message );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = soLoveMessageReadDao.pageMessage(paramMap);
		Integer recordsTotal = soLoveMessageReadDao.pageMessageTotal(message);
		
		/**
		 * 将结果按前台js分页插件的要求装进map
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("draw", draw);
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 新增(发送)消息
	 * @param message 消息
	 * @return
	 */
	public Boolean addMessage(SoLoveMessageParam message) {
		Assert.notNull(soLoveMessageWriteDao, "Property 'soLoveMessageWriteDao' is required.");
		if( message == null ) throw new BusinessException("消息信息不能为空");
		
		Integer result = soLoveMessageWriteDao.addMessage(message);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改消息
	 * @param message 消息
	 * @return
	 */
	public Boolean updateMessage(SoLoveMessageParam message) {
		Assert.notNull(soLoveMessageWriteDao, "Property 'soLoveMessageWriteDao' is required.");
		if( message == null ) throw new BusinessException("消息信息不能为空");
		
		Integer result = soLoveMessageWriteDao.updateMessage(message);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除消息
	 * @param messageID 消息ID
	 * @return
	 */
	public Boolean deleteMessage(Integer messageID) {
		Assert.notNull(soLoveMessageWriteDao, "Property 'soLoveMessageWriteDao' is required.");
		if( messageID == null ) throw new BusinessException("消息ID不能为空");
		
		Integer result = soLoveMessageWriteDao.deleteMessage(messageID);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据消息ID获取消息
	 * @param messageID 消息ID
	 * @return
	 */
	public SoLoveMessageVO getMessageByID(Integer messageID) {
		Assert.notNull(soLoveMessageReadDao, "Property 'soLoveMessageReadDao' is required.");
		if( messageID == null ) throw new BusinessException("消息ID不能为空");
		
		return soLoveMessageReadDao.getMessageByID(messageID);
	}

	/**
	 * 根据发送者ID获取该用户发送过的消息集合
	 * @param sendUserID 发送者ID
	 * @return
	 */
	public List<SoLoveMessageVO> getMessageBySendUserID(Integer sendUserID) {
		Assert.notNull(soLoveMessageReadDao, "Property 'soLoveMessageReadDao' is required.");
		if( sendUserID == null ) throw new BusinessException("sendUserID不能为空");
		
		return soLoveMessageReadDao.getMessageBySendUserID(sendUserID);
	}

	/**
	 * 根据接受者ID后去该用户接收到的消息集合
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	public List<SoLoveMessageVO> getMessageByReceiveUserID(Integer receiveUserID) {
		Assert.notNull(soLoveMessageReadDao, "Property 'soLoveMessageReadDao' is required.");
		if( receiveUserID == null ) throw new BusinessException("receiveUserID不能为空");
		
		return soLoveMessageReadDao.getMessageByReceiveUserID(receiveUserID);
	}

	/**
	 * 获取接收者没有查看的消息个数
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	public Integer getNotLookCountByReceiveUserID(Integer receiveUserID) {
		Assert.notNull(soLoveMessageReadDao, "Property 'soLoveMessageReadDao' is required.");
		if( receiveUserID == null ) throw new BusinessException("receiveUserID不能为空");
		
		return soLoveMessageReadDao.getNotLookCountByReceiveUserID(receiveUserID);
	}

	/**
	 * 设置消息阅读状态
	 * @param messageID 消息ID 
	 * @param isLook 是否阅读过该消息,yes——已读,no——未读,
	 * @return
	 */
	public Boolean setMessageLook(Integer messageID, String isLook) {
		Assert.notNull(soLoveMessageWriteDao, "Property 'soLoveMessageWriteDao' is required.");
		if( messageID == null ) throw new BusinessException("messageID不能为空");
		if( !isLook.equals("yes") || !isLook.equals("no") ) throw new BusinessException("isLook参数不正确");
		
		Integer result =  soLoveMessageWriteDao.setMessageLook(messageID, isLook);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 设置消息审核状态
	 * @param messageID 消息ID 
	 * @param isLook 审核是否通过,yes——通过,no——未通过,
	 * @return
	 */
	public Boolean setMessageAudit(Integer messageID, String isAudit) {
		Assert.notNull(soLoveMessageWriteDao, "Property 'soLoveMessageWriteDao' is required.");
		if( messageID == null ) throw new BusinessException("messageID不能为空");
		if( !isAudit.equals("yes") || !isAudit.equals("no") ) throw new BusinessException("isAudit参数不正确");
		
		Integer result =  soLoveMessageWriteDao.setMessageAudit(messageID, isAudit);
		if( result > 0 ){
			return true;
		} else {
			return false;
		}
	}

}
