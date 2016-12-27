package com.wang.so.love.service.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveParentInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveParentInfoWriteDao;
import com.wang.so.love.service.entity.SoLoveParentInfoEntity;
import com.wang.so.love.service.param.SoLoveParentInfoParam;

/**
 * 用户父母信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.06
 */
@Service
public class SoLoveParentInfoModel {

	/**
	 * soLoveParentInfoReadDao
	 */
	@Autowired
	private SoLoveParentInfoReadDao soLoveParentInfoReadDao;
	
	/**
	 * soLoveParentWriteReadDao
	 */
	@Autowired
	private SoLoveParentInfoWriteDao soLoveParentWriteReadDao;
	

	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * 新增用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 * @return 是否成功
	 */
	public Boolean addParentInfo(SoLoveParentInfoParam parentInfo) {
		Assert.notNull(soLoveParentWriteReadDao, "Property 'soLoveParentWriteReadDao' is required.");
		if( parentInfo.getUserID() == null ) throw new BusinessException("所属用户不能为空");
		if( StringUtils.isBlank(parentInfo.getParentRelation()) ) throw new BusinessException("父母关系不能为空");
		
		Integer result = soLoveParentWriteReadDao.insertParentInfo(parentInfo);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 修改用户父母信息
	 * 
	 * @param parentInfo 用户父母信息
	 * @return 是否成功
	 */
	public Boolean updateParentInfo(SoLoveParentInfoParam parentInfo) {
		Assert.notNull(soLoveParentWriteReadDao, "Property 'soLoveParentWriteReadDao' is required.");
		if( parentInfo.getUserID() == null ) throw new BusinessException("所属用户不能为空");
		if( StringUtils.isBlank(parentInfo.getParentRelation()) ) throw new BusinessException("父母关系不能为空");
		
		Integer result = soLoveParentWriteReadDao.updateParentInfo(parentInfo);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据父母信息ID删除用户父母信息
	 * 
	 * @param parentInfoID 用户父母信息ID
	 * @return 是否成功
	 */
	public Boolean deleteParentInfo(Integer parentID) {
		Assert.notNull(soLoveParentWriteReadDao, "Property 'soLoveParentWriteReadDao' is required.");
		if( parentID == null ) throw new BusinessException("父母信息ID不能为空");
		
		Integer result = soLoveParentWriteReadDao.deleteParentInfo(parentID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据父母信息ID获取用户父母详细信息
	 * 
	 * @param parentID 用户父母信息ID
	 * @return 用户父母信息
	 */
	public SoLoveParentInfoEntity getParentInfoByID(Integer parentID) {
		Assert.notNull(soLoveParentInfoReadDao, "Property 'soLoveParentInfoReadDao' is required.");
		if( parentID == null ) throw new BusinessException("父母信息ID不能为空");
		
		return soLoveParentInfoReadDao.getParentInfoByID(parentID);
	}

	/**
	 * 根据用户ID获取该用户的所有父母
	 * 
	 * @param userID 用户ID
	 * @return 该用户的所有父母信息
	 */
	public List<SoLoveParentInfoEntity> getParentInfoByUserID(Integer userID) {
		Assert.notNull(soLoveParentInfoReadDao, "Property 'soLoveParentInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户信息ID不能为空");
		
		return soLoveParentInfoReadDao.getParentInfoByUserID(userID);
	}

	/**
	 * 修改用户父母信息
	 * 
	 * @return ServiceResult
	 * 
	 * @author HeJiawang
	 * @date   2016.12.27
	 */
	public Boolean modifyUserParent(List<SoLoveParentInfoParam> parentInfoList, Integer userID) {
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		Assert.notNull(soLoveParentWriteReadDao, "Property 'soLoveParentWriteReadDao' is required.");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 1、删除老记录
			 */
			soLoveParentWriteReadDao.deleteUserParent(userID);
			
			/**
			 * 2、新增新记录
			 */
			for( SoLoveParentInfoParam parentInfo : parentInfoList ){
				soLoveParentWriteReadDao.insertParentInfo(parentInfo);
			}
			
			transactionManagerMember.commit(status);
			return true;
		} catch ( Exception e ){
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增用户失败!");
		}
	}
}
