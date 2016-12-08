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
import com.wang.so.love.service.entity.SoLoveActivityEntity;
import com.wang.so.love.service.model.SoLoveAreaModel;
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
	public ServiceResult<List<SoLoveActivityEntity>> getAreaListByParentID(Integer parentID) {
		Assert.notNull(soLoveAreaModel, "Property 'soLoveAreaModel' is required.");
		ServiceResult<List<SoLoveActivityEntity>> serviceResult = new ServiceResult<List<SoLoveActivityEntity>>();
		
		try {
			List<SoLoveActivityEntity> result = soLoveAreaModel.getAreaListByParentID(parentID);
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

}
