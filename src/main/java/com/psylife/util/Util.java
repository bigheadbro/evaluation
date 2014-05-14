package com.psylife.util;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.psylife.common.Account;
import com.psylife.entity.DimensionEntity;
import com.psylife.entity.QuestionEntity;

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

	public static void main(String args[]) {
		Account accnt = getStudentInfo("MjAxMTUyMDAwMg..");
		System.out.println(accnt.getCardno());
		System.out.println(accnt.getSchool());
		System.out.println(accnt.getUserName());
		

	}

}
