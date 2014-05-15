package com.psylife.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.psylife.common.Account;
import com.psylife.common.Constant;
import com.psylife.entity.DimensionEntity;
import com.psylife.entity.QuestionEntity;
import com.psylife.form.QuestionForm;

public class Util {

	public static boolean isMale(int gender) {
		if (gender > 0)
			return true;
		else
			return false;
	}

	// 获取学生信息
	public static Account getStudentInfo(String cardno) {
		Account account = new Account();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("http://180.153.108.93/EvaluationInterface.do?cardno=" + cardno);
			doc.getDocumentElement().normalize();
			account.setCardno(doc.getElementsByTagName("cardno").item(0).getTextContent());
			account.setUserName(doc.getElementsByTagName("name").item(0).getTextContent());
			account.setSchool(doc.getElementsByTagName("shool").item(0).getTextContent());

		} catch (Exception e) {
			
		}

		return account;
	}

	// 计算单选题
	public static QuestionEntity calcSingleScore(DimensionEntity dim, int uid,
			int choice, int time) {
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
	
	// 计算维度题
	public static List<QuestionEntity> calcDimensionScore(DimensionEntity dim, int uid, QuestionForm form) {
		List<QuestionEntity> list = new ArrayList<QuestionEntity>();
		//A
		QuestionEntity ques = new QuestionEntity();
		ques.setUserId(uid);
		ques.setChoice(form.getChoice());
		ques.setTime(form.getTime());
		ques.setQid(dim.getQid());
		ques.setNumber(form.getNumber());
		ques.setLoyalty(dim.getLoyalty()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setPositive(dim.getPositive()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setResponsibility(dim.getResponsibility()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setMorality(dim.getMorality()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setThinking(dim.getThinking()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setPlan(dim.getPlan()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setInnovation(dim.getInnovation()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setTeamwork(dim.getTeamwork()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setCommunication(dim.getCommunication()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setStrain(dim.getStrain()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setDetails(dim.getDetails()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		ques.setPotential(dim.getPotential()*(form.getChoice()-Constant.DIMENSION_CONSTANT));
		//B
		QuestionEntity ques2 = new QuestionEntity();
		ques2.setUserId(uid);
		ques2.setChoice(form.getChoice2());
		ques2.setTime(form.getTime());
		ques2.setQid(dim.getQid());
		ques2.setNumber(form.getNumber2());
		ques2.setLoyalty(dim.getLoyalty()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setPositive(dim.getPositive()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setResponsibility(dim.getResponsibility()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setMorality(dim.getMorality()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setThinking(dim.getThinking()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setPlan(dim.getPlan()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setInnovation(dim.getInnovation()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setTeamwork(dim.getTeamwork()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setCommunication(dim.getCommunication()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setStrain(dim.getStrain()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setDetails(dim.getDetails()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		ques2.setPotential(dim.getPotential()*(form.getChoice2()-Constant.DIMENSION_CONSTANT));
		
		//C
		QuestionEntity ques3 = new QuestionEntity();
		ques3.setUserId(uid);
		ques3.setChoice(form.getChoice3());
		ques3.setTime(form.getTime());
		ques3.setQid(dim.getQid());
		ques3.setNumber(form.getNumber3());
		ques3.setLoyalty(dim.getLoyalty()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setPositive(dim.getPositive()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setResponsibility(dim.getResponsibility()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setMorality(dim.getMorality()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setThinking(dim.getThinking()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setPlan(dim.getPlan()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setInnovation(dim.getInnovation()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setTeamwork(dim.getTeamwork()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setCommunication(dim.getCommunication()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setStrain(dim.getStrain()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setDetails(dim.getDetails()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
		ques3.setPotential(dim.getPotential()*(form.getChoice3()-Constant.DIMENSION_CONSTANT));
				
		//D
		QuestionEntity ques4 = new QuestionEntity();
		ques4.setUserId(uid);
		ques4.setChoice(form.getChoice4());
		ques4.setTime(form.getTime());
		ques4.setQid(dim.getQid());
		ques4.setNumber(form.getNumber4());
		ques4.setLoyalty(dim.getLoyalty()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setPositive(dim.getPositive()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setResponsibility(dim.getResponsibility()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setMorality(dim.getMorality()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setThinking(dim.getThinking()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setPlan(dim.getPlan()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setInnovation(dim.getInnovation()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setTeamwork(dim.getTeamwork()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setCommunication(dim.getCommunication()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setStrain(dim.getStrain()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setDetails(dim.getDetails()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		ques4.setPotential(dim.getPotential()*(form.getChoice4()-Constant.DIMENSION_CONSTANT));
		
		list.add(ques);
		list.add(ques2);
		list.add(ques3);
		list.add(ques4);
		return list;
	}

	public static void main(String args[]) {
		Account accnt = getStudentInfo("MjAxMTUyMDAwMg..");
		System.out.println(accnt.getCardno());
		System.out.println(accnt.getSchool());
		System.out.println(accnt.getUserName());
		

	}

}
