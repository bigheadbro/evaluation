package com.psylife.dao;

import com.psylife.entity.UserEntity;;

public interface UserDAO {
	/**
	 * @param id
	 * @return
	 */
	UserEntity queryUserEntityById(int id);

	UserEntity queryUserEntityByCN(String cn);
	
	int updateStateById(UserEntity user);
	
	/**
	 * 插入买家信息
	 * @param companyUser
	 * @return
	 */
	public int insertUserEntity(UserEntity user);
}
