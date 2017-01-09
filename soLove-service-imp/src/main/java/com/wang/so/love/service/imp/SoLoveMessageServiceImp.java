package com.wang.so.love.service.imp;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.model.SoLoveMessageModel;
import com.wang.so.love.service.param.SoLoveMessageParam;
import com.wang.so.love.service.service.SoLoveMessageService;
import com.wang.so.love.service.vo.SoLoveMessageVO;

/**
 * 消息service Imp
 * 
 * @author HeJiawang
 * @date   2017.01.09
 */
@Service
public class SoLoveMessageServiceImp implements SoLoveMessageService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveMessageServiceImp.class);
	
	/**
	 * soLoveMessageModel
	 */
	@Autowired
	private SoLoveMessageModel soLoveMessageModel;
	
	/**
	 * 分页获取消息信息
	 * @param message 查询参数
	 * @param start 分页——
	 * @param length 分页——
	 * @param draw 分页——
	 * @return
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageMessage(SoLoveMessageParam message, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveActivityModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveMessageModel.pageMessage(message, start, length, draw);
			serviceResult.setResult(resultMap);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 新增(发送)消息
	 * @param message 消息
	 * @return
	 */
	@Override
	public ServiceResult<Void> addMessage(SoLoveMessageParam message) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveMessageModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMessageModel.addMessage(message);
			if( isSuccess ){
				serviceResult.setMessage("新增成功");
			} else {
				serviceResult.setMessage("新增失败");
			}
			serviceResult.setSuccess(isSuccess);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 修改消息
	 * @param message 消息
	 * @return
	 */
	@Override
	public ServiceResult<Void> updateMessage(SoLoveMessageParam message) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMessageModel.updateMessage(message);
			if( isSuccess ){
				serviceResult.setMessage("修改成功");
			} else {
				serviceResult.setMessage("修改失败");
			}
			serviceResult.setSuccess(isSuccess);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 删除消息
	 * @param messageID 消息ID
	 * @return
	 */
	@Override
	public ServiceResult<Void> deleteMessage(Integer messageID) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMessageModel.deleteMessage(messageID);
			if( isSuccess ){
				serviceResult.setMessage("删除成功");
			} else {
				serviceResult.setMessage("删除失败");
			}
			serviceResult.setSuccess(isSuccess);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
	
	/**
	 * 根据消息ID获取消息
	 * @param messageID 消息ID
	 * @return
	 */
	@Override
	public ServiceResult<SoLoveMessageVO> getMessageByID(Integer messageID) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<SoLoveMessageVO> serviceResult = new ServiceResult<SoLoveMessageVO>();
		try {
			SoLoveMessageVO message = soLoveMessageModel.getMessageByID(messageID);
			serviceResult.setResult(message);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
	
	/**
	 * 根据发送者ID获取该用户发送过的消息集合
	 * @param sendUserID 发送者ID
	 * @return
	 */
	@Override
	public ServiceResult<List<SoLoveMessageVO>> getMessageBySendUserID(Integer sendUserID) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<List<SoLoveMessageVO>> serviceResult = new ServiceResult<List<SoLoveMessageVO>>();
		try {
			List<SoLoveMessageVO> message = soLoveMessageModel.getMessageBySendUserID(sendUserID);
			serviceResult.setResult(message);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 根据接受者ID后去该用户接收到的消息集合
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	@Override
	public ServiceResult<List<SoLoveMessageVO>> getMessageByReceiveUserID(Integer receiveUserID) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<List<SoLoveMessageVO>> serviceResult = new ServiceResult<List<SoLoveMessageVO>>();
		try {
			List<SoLoveMessageVO> message = soLoveMessageModel.getMessageByReceiveUserID(receiveUserID);
			serviceResult.setResult(message);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
	
	/**
	 * 获取接收者没有查看的消息个数
	 * @param receiveUserID 接收者ID
	 * @return
	 */
	@Override
	public ServiceResult<Integer> getNotLookCountByReceiveUserID(Integer receiveUserID) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		try {
			Integer message = soLoveMessageModel.getNotLookCountByReceiveUserID(receiveUserID);
			serviceResult.setResult(message);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
	
	/**
	 * 设置消息阅读状态
	 * @param messageID 消息ID 
	 * @param isLook 是否阅读过该消息,yes——已读,no——未读,
	 * @return
	 */
	@Override
	public ServiceResult<Void> setMessageLook(Integer messageID, String isLook) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMessageModel.setMessageLook(messageID, isLook);
			if( isSuccess ){
				serviceResult.setMessage("设置成功");
			} else {
				serviceResult.setMessage("设置失败");
			}
			serviceResult.setSuccess(isSuccess);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
	
	/**
	 * 设置消息审核状态
	 * @param messageID 消息ID 
	 * @param isLook 审核是否通过,yes——通过,no——未通过,
	 * @return
	 */
	@Override
	public ServiceResult<Void> setMessageAudit(Integer messageID, String isAudit) {
		Assert.notNull(soLoveMessageModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveMessageModel.setMessageAudit(messageID, isAudit);
			if( isSuccess ){
				serviceResult.setMessage("设置成功");
			} else {
				serviceResult.setMessage("设置失败");
			}
			serviceResult.setSuccess(isSuccess);
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

}
