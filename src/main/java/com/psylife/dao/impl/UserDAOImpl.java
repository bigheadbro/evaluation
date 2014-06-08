package com.psylife.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.psylife.dao.UserDAO;
import com.psylife.entity.UserEntity;

@Repository("userDAO")
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {

	@Override
	public UserEntity queryUserEntityById(int id) {
		return this.getSqlSession().selectOne("queryUserEntityById", id);
	}
	
	@Override
	public UserEntity queryUserEntityByCN(String cn) {
		return this.getSqlSession().selectOne("queryUserEntityByCN", cn);
	}
	
	@Override
	public int insertUserEntity(UserEntity user) {
		this.getSqlSession().insert("insertUserEntity", user);
		return user.getId();
	}
	
	@Override
	public int updateStateById(UserEntity user) {
		return this.getSqlSession().update("updateStateById", user);
	}

}
