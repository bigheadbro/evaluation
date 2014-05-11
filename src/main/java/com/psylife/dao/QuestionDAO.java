package com.psylife.dao;

import com.psylife.entity.QuestionEntity;;

public interface QuestionDAO {
	/**
	 * 插入回答信息
	 * @param companyUser
	 * @return
	 */
	public int insertQuestionEntity(QuestionEntity question);
}
