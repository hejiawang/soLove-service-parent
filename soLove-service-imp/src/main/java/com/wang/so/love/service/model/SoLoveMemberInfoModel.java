package com.wang.so.love.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.write.SoLoveUserInfoWriteDao;
import com.wang.so.love.service.entity.SoLoveMemberInfoEntity;
import com.wang.so.love.service.dao.read.SoLoveMemberInfoReadDao;
import com.wang.so.love.service.dao.write.SoLoveMemberInfoWriteDao;
import com.wang.so.love.service.param.SoLoveMemberInfoParam;

/**
 * 会员信息Model
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveMemberInfoModel {

	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * soLoveUserInfoWriteDao
	 */
	@Autowired
	private SoLoveUserInfoWriteDao soLoveUserInfoWriteDao;
	
	/**
	 * soLoveMemberInfoWriteDao
	 */
	@Autowired
	private SoLoveMemberInfoWriteDao soLoveMemberInfoWriteDao;
	
	/**
	 * soLoveMemberInfoReadDao
	 */
	@Autowired
	private SoLoveMemberInfoReadDao soLoveMemberInfoReadDao;
	
	/**
	 * 为用户开通会员
	 * 
	 * @param memberInfo 会员信息
	 * @return 是否开通成功
	 */
	public Boolean openMemberForUser(SoLoveMemberInfoParam memberInfo) {
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		Assert.notNull(soLoveUserInfoWriteDao, "Property 'soLoveUserInfoWriteDao' is required.");
		Assert.notNull(soLoveMemberInfoWriteDao, "Property 'soLoveMemberInfoWriteDao' is required.");
		if( memberInfo.getUserID() == null ) throw new BusinessException("用户ID不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 更改userInfo表的userLevel字段为member
			 */
			Integer result = soLoveUserInfoWriteDao.updateUserLevel("member", memberInfo.getUserID());
			
			/**
			 * 向会员表中插入会员信息
			 */
			result = soLoveMemberInfoWriteDao.insertMemberInfo(memberInfo);
			
			transactionManagerMember.commit(status);
		
			if( result >= 1 ){
				return true;
			} else {
				return false;
			}
		} catch ( Exception e ){
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增用户失败!");
		}
		
	}

	/**
	 * 会员信息查看
	 * 
	 * @param userID 用户ID
	 * @return 会员信息
	 * 
	 * @author HeJiawang
	 * @date 2016.12.28
	 */
	public SoLoveMemberInfoEntity getMemberInfoByUserID(Integer userID) {
		Assert.notNull(soLoveMemberInfoReadDao, "Property 'soLoveMemberInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return soLoveMemberInfoReadDao.getMemberInfoByUserID(userID);
	}

}
