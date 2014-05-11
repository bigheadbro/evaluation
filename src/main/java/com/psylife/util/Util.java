package com.psylife.util;

import com.psylife.entity.DimensionEntity;
import com.psylife.entity.QuestionEntity;

public class Util {
	
	public static boolean isMale(int gender)
	{
		if(gender > 0)
			return true;
		else
			return false;
	}
	
	//计算单选题
	public static QuestionEntity calcSingleScore(DimensionEntity dim, int uid, int choice, int time)
	{
		QuestionEntity ques = new QuestionEntity();
		ques.setUserId(uid);
		ques.setChoice(choice);
		ques.setTime(time);
		ques.setQid(dim.getQid());
		ques.setNumber(dim.getNumber());
		ques.setLoyalty(dim.getLoyalty());
		ques.setPositive(dim.getPositive());
		ques.setResponsibility(dim.getResponsibility());
		ques.setMorality(dim.getMorality());
		ques.setThinking(dim.getThinking());
		ques.setPlan(dim.getPlan());
		ques.setInnovation(dim.getInnovation());
		ques.setTeamwork(dim.getTeamwork());
		ques.setCommunication(dim.getCommunication());
		ques.setStrain(dim.getStrain());
		ques.setDetails(dim.getDetails());
		ques.setPotential(dim.getPotential());
		return ques;
	}

}
