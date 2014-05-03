package com.psylife.dao;

import com.psylife.entity.UserEntity;;

public interface BuyerDAO {
	/**
	 * @param id
	 * @return
	 */
	UserEntity queryBuyerEntityById(int id);
	
	/**
	 * @param name
	 * @return
	 */
	UserEntity queryBuyerEntityByMail(String mail);
	
	UserEntity queryBuyerEntityByName(String mail);
	
	/**
	 * 插入买家信息
	 * @param companyUser
	 * @return
	 */
	public int insertBuyerEntity(UserEntity buyer);
	

	/**
	 * 更新买家密码
	 * @param agent
	 * @return
	 */
	public int updateBuyerPwdById(UserEntity buyer);
	
	public int updateBuyerEntityById(UserEntity buyer);
	
	public UserEntity buyerLoginByQQConnect(String qqConncetId);
}
