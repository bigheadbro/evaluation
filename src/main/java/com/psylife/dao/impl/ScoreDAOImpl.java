package com.psylife.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import com.psylife.dao.ScoreDAO;
import com.psylife.entity.ScoreEntity;

@Repository("scoreDAO")
public class ScoreDAOImpl extends SqlSessionDaoSupport implements ScoreDAO {

	@Override
	public ScoreEntity queryScoreByUserid(int userid) {
		return this.getSqlSession().selectOne("queryScoreByUserid",userid);
	}


}
