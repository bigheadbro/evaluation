package com.psylife.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class QuestionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5018466185393518841L;
		
	private int id;
	
	private String title;
	
	//问题属于哪个领域
	private int area;
	
	//得分
	private int score;
	
	private int type;
	
	private List<String> answer;
	
	//这道题考虑时间
	private int userdTime;
	
	private Map<Integer,QuestionEntity> questionMap;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the answer
	 */
	public List<String> getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the questionMap
	 */
	public Map<Integer,QuestionEntity> getQuestionMap() {
		return questionMap;
	}

	/**
	 * @param questionMap the questionMap to set
	 */
	public void setQuestionMap(Map<Integer,QuestionEntity> questionMap) {
		this.questionMap = questionMap;
	}

	/**
	 * @return the userdTime
	 */
	public int getUserdTime() {
		return userdTime;
	}

	/**
	 * @param userdTime the userdTime to set
	 */
	public void setUserdTime(int userdTime) {
		this.userdTime = userdTime;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(int area) {
		this.area = area;
	}
}