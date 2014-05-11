package com.psylife.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -344076978051360475L;
	//
	private int id;
	// 用户名字
	private String name;
	private int gender;
	private String birth;
	private String domicile;
	private String school;
	private String major;
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return the domicile
	 */
	public String getDomicile() {
		return domicile;
	}

	/**
	 * @param domicile the domicile to set
	 */
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
}