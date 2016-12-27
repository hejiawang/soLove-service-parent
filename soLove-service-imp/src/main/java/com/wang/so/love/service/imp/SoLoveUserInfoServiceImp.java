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
import com.wang.so.love.service.model.SoLoveUserInfoModel;
import com.wang.so.love.service.param.SoLoveMateInfoParam;
import com.wang.so.love.service.param.SoLoveUserDetailInfoParam;
import com.wang.so.love.service.param.SoLoveUserInfoParam;
import com.wang.so.love.service.service.SoLoveUserInfoService;
import com.wang.so.love.service.vo.SoLoveUserSimpleInfoVO;

/**
 * 用户基本信息接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveUserInfoServiceImp implements SoLoveUserInfoService {
	
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveUserInfoServiceImp.class);
	
	/**
	 * soLoveUserInfoModel 
	 */
	@Autowired
	private SoLoveUserInfoModel soLoveUserInfoModel;
	
	/**
	 * 新增一个普通注册用户</br>
	 * 记录登录手机号、密码、注册方式的信息</br>
	 * 并在详细信息表、照片表、择偶信息表中新建一条与该用户对应的数据</br>
	 * 若要填写详细信息,应进行信息维护</br>
	 * 
	 * 注意:本方法用户后台添加用户,app注册应调用SoLoveLoginService
	 * 
	 * @param userInfo 用户信息
	 */
	@Override
	public ServiceResult<Void> addUserInfo(SoLoveUserInfoParam userInfo) {
		Assert.notNull(soLoveUserInfoModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean checkSuccess = soLoveUserInfoModel.checkUserInfo(userInfo);	//判断loginName是否重复,true——重复
			if( !checkSuccess ){
				serviceResult.setMessage("手机号码重复!");
				serviceResult.setSuccess(false);
			} else {
				Boolean isSuccess = soLoveUserInfoModel.addUserInfo(userInfo);
				if( isSuccess ){
					serviceResult.setMessage("新增用户成功");
				} else {
					serviceResult.setMessage("新增用户失败");
				}
				serviceResult.setSuccess(isSuccess);
			}
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
	 * 删除用户
	 * 
	 * @param userID 用户ID
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	@Override
	public ServiceResult<Void> deleteUserInfo(Integer userID) {
		Assert.notNull(soLoveUserInfoModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveUserInfoModel.deleteUserInfo(userID);
			if( isSuccess ){
				serviceResult.setMessage("删除用户成功");
			} else {
				serviceResult.setMessage("删除用户失败");
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
	 * 根据用户ID查看用户的信息——详细信息、照片、爱好、子女父母等所有信息 
	 * 
	 * @param userID 用户ID
	 * 
	 * @return 
	 * 		用户信息Map</br>
	 * 		<li>key:userInfo——用户基本信息</li>
	 * 		<li>key:userDetail——用户详细信息</li>
	 * 		<li>key:userImg——用户照片信息</li>
	 * 		<li>key:userHobby——用户兴趣爱好信息</li>
	 * 		<li>key:userParent——用户父母信息</li>
	 * 		<li>key:userChildren——用户子女信息</li>
	 * 		<li>key:userMate——用户择偶信息</li>
	 * 
	 * @author HeJiawang
	 * @date 2016.12.08
	 */
	@Override
	public ServiceResult<Map<String, Object>> viewUserInfo(Integer userID) {
		Assert.notNull(soLoveUserInfoModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveUserInfoModel.viewUserInfo(userID);
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
	 * 根据择偶条件筛选信息</br>
	 * 并进行分页
	 * 
	 * @param mateInfo 择偶信息
	 * @return 简单的用户信息,如：年龄、兴趣爱好等
	 * 
	 * @author HeJiawang
	 * @date   2016.12.07
	 */
	@Override
	public ServiceResult<List<SoLoveUserSimpleInfoVO>> getUserByMateInfo(SoLoveMateInfoParam mateInfo) {
		Assert.notNull(soLoveUserInfoModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<List<SoLoveUserSimpleInfoVO>> serviceResult = new ServiceResult<List<SoLoveUserSimpleInfoVO>>();
		try {
			List<SoLoveUserSimpleInfoVO> userSimpleInfo = soLoveUserInfoModel.getUserByMateInfo(mateInfo);
			serviceResult.setResult(userSimpleInfo);
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
	 * 根据条件搜索用户信息</br>
	 * 并进行分页
	 * 
	 * @param param 检索条件
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * 
	 * @return 适应So love后台管理系统js分页插件的Map
	 * 
	 * @author HeJiawang
	 * @date   2016.12.08
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageUserInfo(SoLoveUserDetailInfoParam param, Integer start,
			Integer length, Integer draw) {
		Assert.notNull(soLoveUserInfoModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveUserInfoModel.pageUserInfo(param, start, length, draw);
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
	 * 修改用户基本信息
	 * 
	 * @param userInfo 用户基本信息参数
	 * 
	 * @author HeJiawang
	 * @date   2016.12.27
	 */
	@Override
	public ServiceResult<Void> updateUserInfo(SoLoveUserInfoParam userInfo) {
		Assert.notNull(soLoveUserInfoModel, "Property 'soLoveUserInfoModel' is required.");
		
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try{
			Boolean isSuccess = soLoveUserInfoModel.updateUserInfo(userInfo);
			if( isSuccess ){
				serviceResult.setMessage("修改成功");
			} else {
				serviceResult.setMessage("修改失败");
			}
			serviceResult.setSuccess(isSuccess);
		}catch (BusinessException e) {
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
