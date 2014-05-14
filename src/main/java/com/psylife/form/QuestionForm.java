package com.psylife.form;

import java.io.Serializable;

public class QuestionForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7238602389806897715L;
	
	private int questionid;
	
	private int choice;
	
	private int male;
	
	private int time;
	
	private int number;

	/**
	 * @return the qustionid
	 */
	public int getQuestionid() {
		return questionid;
	}

	/**
	 * @param qustionid the qustionid to set
	 */
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	/**
	 * @return the answer
	 */
	public int getChoice() {
		return choice;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setChoice(int choice) {
		this.choice = choice;
	}

	/**
	 * @return the male
	 */
	public int getMale() {
		return male;
	}

	/**
	 * @param male the male to set
	 */
	public void setMale(int male) {
		this.male = male;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


}
