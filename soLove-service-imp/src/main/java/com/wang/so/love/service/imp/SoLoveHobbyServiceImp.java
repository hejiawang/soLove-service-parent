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
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.model.SoLoveHobbyModel;
import com.wang.so.love.service.param.SoLoveHobbyParam;
import com.wang.so.love.service.service.SoLoveHobbyService;

/**
 * 兴趣爱好接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveHobbyServiceImp implements SoLoveHobbyService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveHobbyServiceImp.class);
	
	/**
	 * soLoveHobbyModel
	 */
	@Autowired
	private SoLoveHobbyModel soLoveHobbyModel;
	
	/**
	 * 新增兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 */
	@Override
	public ServiceResult<Void> addHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.addHobby(hobby);
			if( isSuccess ){
				serviceResult.setMessage("新增信息成功");
			} else {
				serviceResult.setMessage("新增信息失败");
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
	 * 修改兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 */
	@Override
	public ServiceResult<Void> modifyHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.modifyHobby(hobby);
			if( isSuccess ){
				serviceResult.setMessage("修改信息成功");
			} else {
				serviceResult.setMessage("修改信息失败");
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
	 * 删除兴趣爱好
	 * 
	 * @param hobbyID 兴趣爱好ID
	 */
	@Override
	public ServiceResult<Void> deleteHobby(Integer hobbyID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.deleteHobby(hobbyID);
			if( isSuccess ){
				serviceResult.setMessage("删除信息成功");
			} else {
				serviceResult.setMessage("删除信息失败");
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
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 */
	@Override
	public ServiceResult<SoLoveHobbyEntity> getHobbyByID(Integer hobbyID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<SoLoveHobbyEntity> serviceResult = new ServiceResult<SoLoveHobbyEntity>();
		try {
			SoLoveHobbyEntity hobby = soLoveHobbyModel.getHobbyByID(hobbyID);
			serviceResult.setResult(hobby);
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
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 */
	@Override
	public ServiceResult<List<SoLoveHobbyEntity>> getHobbyByUserID(Integer userID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<List<SoLoveHobbyEntity>> serviceResult = new ServiceResult<List<SoLoveHobbyEntity>>();
		try {
			List<SoLoveHobbyEntity> hobbyList = soLoveHobbyModel.getHobbyByUserID(userID);
			serviceResult.setResult(hobbyList);
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
	 * 用户兴趣爱好维护
	 * 
	 * @param hobbyIDs 兴趣爱好ID集合
	 * @param userID 用户ID
	 */
	@Override
	public ServiceResult<Void> modifyUserHobby(Integer userID, List<Integer> hobbyIDs) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveHobbyModel.modifyUserHobby(userID, hobbyIDs);
			if( isSuccess ){
				serviceResult.setMessage("信息维护成功");
			} else {
				serviceResult.setMessage("信息维护失败");
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
	 * 获取所有兴趣爱好
	 * 
	 * @author HeJiawang
	 * @date  2016.12.27
	 */
	@Override
	public ServiceResult<List<SoLoveHobbyEntity>> getAllHobby() {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<List<SoLoveHobbyEntity>> serviceResult = new ServiceResult<List<SoLoveHobbyEntity>>();
		try {
			List<SoLoveHobbyEntity> hobbyList = soLoveHobbyModel.getAllHobby();
			serviceResult.setResult(hobbyList);
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
	 * 分页获取兴趣爱好信息
	 * 
	 * @param param 查询信息
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageHobby(SoLoveHobbyParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveHobbyModel.pageHobby(param, start, length, draw);
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
	 * 获取兴趣爱好树
	 * 
	 * @param id 父兴趣爱好ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	@Override
	public ServiceResult<List<SoLoveHobbyParam>> getHobbyTreeData(Integer parentHobbyID) {
		Assert.notNull(soLoveHobbyModel, "Property 'soLoveHobbyModel' is required.");
		ServiceResult<List<SoLoveHobbyParam>> serviceResult = new ServiceResult<List<SoLoveHobbyParam>>();
		try {
			List<SoLoveHobbyParam> list = soLoveHobbyModel.getHobbyTreeData(parentHobbyID);
			serviceResult.setResult(list);
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
