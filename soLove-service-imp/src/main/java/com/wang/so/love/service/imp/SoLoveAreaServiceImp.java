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
import com.wang.so.love.service.entity.SoLoveAreaEntity;
import com.wang.so.love.service.model.SoLoveAreaModel;
import com.wang.so.love.service.param.SoLoveAreaParam;
import com.wang.so.love.service.service.SoLoveAreaService;

/**
 * 地区接口实现
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveAreaServiceImp implements SoLoveAreaService {

	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SoLoveAreaServiceImp.class);
	
	/**
	 * soLoveAreaModel
	 */
	@Autowired
	private SoLoveAreaModel soLoveAreaModel;
	
	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	@Override
	public ServiceResult<List<SoLoveAreaEntity>> getAreaListByParentID(Integer parentID) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveAreaModel' is required.");
		ServiceResult<List<SoLoveAreaEntity>> serviceResult = new ServiceResult<List<SoLoveAreaEntity>>();
		
		try {
			List<SoLoveAreaEntity> result = soLoveAreaModel.getAreaListByParentID(parentID);
			serviceResult.setResult(result);
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
	 * 分页获取地区信息
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
	public ServiceResult<Map<String, Object>> pageAera(SoLoveAreaParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<Map<String, Object>>();
		try {
			Map<String, Object> resultMap = soLoveAreaModel.pageAera(param, start, length, draw);
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
	 * 删除地区
	 * @param areaID 地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	@Override
	public ServiceResult<Void> deleteArea(Integer areaID) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveAreaModel.deleteArea(areaID);
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
	 * 新增地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	@Override
	public ServiceResult<Void> raiseArea(SoLoveAreaParam area) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveAreaModel.raiseArea(area);
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
	 * 修改地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	@Override
	public ServiceResult<Void> modifyArea(SoLoveAreaParam area) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<Void>();
		try {
			Boolean isSuccess = soLoveAreaModel.modifyArea(area);
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
	 * 获取地区树
	 * 
	 * @param id 父地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	@Override
	public ServiceResult<List<SoLoveAreaParam>> getAreaTreeData(Integer parentID) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveUserInfoModel' is required.");
		ServiceResult<List<SoLoveAreaParam>> serviceResult = new ServiceResult<List<SoLoveAreaParam>>();
		try {
			List<SoLoveAreaParam> list = soLoveAreaModel.getAreaTreeData(parentID);
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
