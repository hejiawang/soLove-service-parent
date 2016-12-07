package com.wang.so.love.service.imp;

import java.util.List;

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

}
