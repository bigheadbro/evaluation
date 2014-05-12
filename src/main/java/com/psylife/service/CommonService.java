package com.psylife.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.psylife.dao.DimensionDAO;
import com.psylife.dao.QuestionDAO;
import com.psylife.dao.UserDAO;
import com.psylife.entity.DimensionEntity;
import com.psylife.entity.QuestionEntity;
import com.psylife.entity.UserEntity;


/**
 * @author guichaoqun
 *
 */
@Service("commonService")
public class CommonService {
	@Autowired
	@Qualifier("dimensionDAO")
	private DimensionDAO dimensionDAO;

	@Autowired
	@Qualifier("questionDAO")
	private QuestionDAO questionDAO;
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	public DimensionEntity getDim(int qid, int choice)
	{
		DimensionEntity dim = new DimensionEntity();
		dim.setQid(qid);
		dim.setChoice(choice);
    	return dimensionDAO.queryDimensionByQid(dim);
	}
	
	public int insertQuestion(QuestionEntity ques)
	{
		return questionDAO.insertQuestionEntity(ques);
	}
	
	public int insertUser(UserEntity user)
	{
		return userDAO.insertUserEntity(user);
	}
	

}