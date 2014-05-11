package com.psylife.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.psylife.dao.QuestionDAO;
import com.psylife.entity.QuestionEntity;

@Repository("questionDAO")
public class QuestionDAOImpl extends SqlSessionDaoSupport implements QuestionDAO {
	@Override
	public int insertQuestionEntity(QuestionEntity question)
	{
		this.getSqlSession().insert("insertQuestionEntity", question);
		return question.getId();
	}

}
