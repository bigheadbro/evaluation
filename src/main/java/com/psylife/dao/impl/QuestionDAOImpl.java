package com.psylife.dao.impl;

import java.util.List;

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

	@Override
	public int insertQuestionList(List<QuestionEntity> list)
	{
		int i = this.getSqlSession().insert("insertQuestionList", list);
		return i;
	}
}
