package com.wang.so.love.service.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.so.love.service.dao.read.SoLoveHobbyReadDao;
import com.wang.so.love.service.dao.write.SoLoveHobbyWriteDao;
import com.wang.so.love.service.entity.SoLoveHobbyEntity;
import com.wang.so.love.service.param.SoLoveHobbyParam;

/**
 * 兴趣爱好Model
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class SoLoveHobbyModel {

	/**
	 * soLoveHobbyReadDao
	 */
	@Autowired
	private SoLoveHobbyReadDao soLoveHobbyReadDao;
	
	/**
	 * SoLoveHobbyWriteDao
	 */
	@Autowired
	private SoLoveHobbyWriteDao SoLoveHobbyWriteDao;
	
	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * 新增兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 * @return 是否新增成功
	 */
	public Boolean addHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( hobby == null ) throw new BusinessException("兴趣爱好不能为空");
		
		Integer result = SoLoveHobbyWriteDao.addHobby(hobby);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 修改兴趣爱好
	 * 
	 * @param hobby 兴趣爱好
	 * @return 是否修改成功
	 */
	public Boolean modifyHobby(SoLoveHobbyParam hobby) {
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( hobby.getHobbyID() == null ) throw new BusinessException("兴趣爱好ID不能为空");
		
		Integer result = SoLoveHobbyWriteDao.modifyHobby(hobby);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 删除兴趣爱好
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 是否删除成功
	 */
	public Boolean deleteHobby(Integer hobbyID) {
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( hobbyID == null ) throw new BusinessException("兴趣爱好ID不能为空");
		
		Integer result = SoLoveHobbyWriteDao.deleteHobby(hobbyID);
		if( result >= 1 ){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据兴趣爱好ID获取内容
	 * 
	 * @param hobbyID 兴趣爱好ID
	 * @return 兴趣爱好
	 */
	public SoLoveHobbyEntity getHobbyByID(Integer hobbyID) {
		Assert.notNull(soLoveHobbyReadDao, "Property 'soLoveHobbyReadDao' is required.");
		if( hobbyID == null ) throw new BusinessException("兴趣爱好ID不能为空");
		
		return soLoveHobbyReadDao.getHobbyByID(hobbyID);
	}

	/**
	 * 根据用户ID获取该用户兴趣爱好
	 * 
	 * @param userID 用户ID
	 * @return 兴趣爱好集合
	 */
	public List<SoLoveHobbyEntity> getHobbyByUserID(Integer userID) {
		Assert.notNull(soLoveHobbyReadDao, "Property 'soLoveHobbyReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return soLoveHobbyReadDao.getHobbyByUserID(userID);
	}

	/**
	 * 获取所有兴趣爱好
	 * 
	 * @author HeJiawang
	 * @date  2016.12.27
	 */
	public List<SoLoveHobbyEntity> getAllHobby() {
		Assert.notNull(soLoveHobbyReadDao, "Property 'soLoveHobbyReadDao' is required.");
		
		return soLoveHobbyReadDao.getAllHobby();
	}
	
	/**
	 * 用户兴趣爱好维护
	 * 
	 * @param hobbyIDs 兴趣爱好ID集合
	 * @param userID 用户ID
	 */
	public Boolean modifyUserHobby(Integer userID, List<Integer> hobbyIDs) {
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		Assert.notNull(SoLoveHobbyWriteDao, "Property 'SoLoveHobbyWriteDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 1、删除用户兴趣爱好表中已有的关联数据
			 */
			SoLoveHobbyWriteDao.deleteUserHobby(userID);
			
			/**
			 * 2、新增新的兴趣爱好
			 */
			for( Integer hobbyID : hobbyIDs ){
				SoLoveHobbyWriteDao.addUserHobby(userID, hobbyID);
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
