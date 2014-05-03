package com.psylife.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.psylife.dao.BuyerDAO;
import com.psylife.entity.UserEntity;

@Repository("buyerDAO")
public class BuyerDAOImpl extends SqlSessionDaoSupport implements BuyerDAO {

	@Override
	public UserEntity queryBuyerEntityById(int id) {
		return this.getSqlSession().selectOne("queryBuyerEntityById", id);
	}
	
	@Override
	public UserEntity queryBuyerEntityByMail(String mail) {
		return this.getSqlSession().selectOne("queryBuyerEntityByMail", mail);
	}

	@Override
	public UserEntity queryBuyerEntityByName(String name) {
		return this.getSqlSession().selectOne("queryBuyerEntityByName", name);
	}
	
	@Override
	public int insertBuyerEntity(UserEntity buyer) {
		this.getSqlSession().insert("insertBuyerEntity", buyer);
		return buyer.getId();
	}

	@Override
	public int updateBuyerPwdById(UserEntity buyer) {
		return this.getSqlSession().update("updateBuyerPasswordById", buyer);
	}

	@Override
	public int updateBuyerEntityById(UserEntity buyer) {
		return this.getSqlSession().update("updateBuyerById", buyer);
	}

	@Override
	public UserEntity buyerLoginByQQConnect(String qqConncetId)
	{
		return  this.getSqlSession().selectOne("buyerLoginByQQConnect", qqConncetId);
	}

}
