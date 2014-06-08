package com.psylife.service;


import java.util.List;

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
	
	public DimensionEntity getDim(int qid, int choice, int number)
	{
		DimensionEntity dim = new DimensionEntity();
		dim.setQid(qid);
		dim.setChoice(choice);
		dim.setNumber(number);
    	return dimensionDAO.queryDimensionByQid(dim);
	}
	
	public int insertQuestion(QuestionEntity ques)
	{
		return questionDAO.insertQuestionEntity(ques);
	}
	
	public int insertQuestionList(List<QuestionEntity> list)
	{
		return questionDAO.insertQuestionList(list);
	}
	
	public int insertUser(UserEntity user)
	{
		return userDAO.insertUserEntity(user);
	}
	
	public UserEntity getUser(int id)
	{
		return userDAO.queryUserEntityById(id);
	}
	
	public UserEntity getUserByCN(String cn)
	{
		return userDAO.queryUserEntityByCN(cn);
	}
	
	public void updateState(UserEntity user)
	{
		userDAO.updateStateById(user);
	}
	

}