package com.psylife.entity;

import java.io.Serializable;

public class DimensionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7630137768813639287L;
	//
	private int id;
	//
	private int qid;
	private String title;
	//
	private int number;
	private String subtitle;
	//
	private int choice;
	private String answer;
	//
	private int loyalty;
	//
	private int positive;
	//
	private int responsibility;
	//
	private int morality;
	//
	private int thinking;
	//
	private int plan;
	//
	private int innovation;
	//
	private int teamwork;
	//
	private int communication;
	//
	private int strain;
	//
	private int details;
	//
	private int potential;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the qid
	 */
	public int getQid() {
		return qid;
	}

	/**
	 * @param qid
	 *            the qid to set
	 */
	public void setQid(int qid) {
		this.qid = qid;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the loyalty
	 */
	public int getLoyalty() {
		return loyalty;
	}

	/**
	 * @param loyalty
	 *            the loyalty to set
	 */
	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}

	/**
	 * @return the positive
	 */
	public int getPositive() {
		return positive;
	}

	/**
	 * @param positive
	 *            the positive to set
	 */
	public void setPositive(int positive) {
		this.positive = positive;
	}

	/**
	 * @return the responsibility
	 */
	public int getResponsibility() {
		return responsibility;
	}

	/**
	 * @param responsibility
	 *            the responsibility to set
	 */
	public void setResponsibility(int responsibility) {
		this.responsibility = responsibility;
	}

	/**
	 * @return the morality
	 */
	public int getMorality() {
		return morality;
	}

	/**
	 * @param morality
	 *            the morality to set
	 */
	public void setMorality(int morality) {
		this.morality = morality;
	}

	/**
	 * @return the thinking
	 */
	public int getThinking() {
		return thinking;
	}

	/**
	 * @param thinking
	 *            the thinking to set
	 */
	public void setThinking(int thinking) {
		this.thinking = thinking;
	}

	/**
	 * @return the plan
	 */
	public int getPlan() {
		return plan;
	}

	/**
	 * @param plan
	 *            the plan to set
	 */
	public void setPlan(int plan) {
		this.plan = plan;
	}

	/**
	 * @return the innovation
	 */
	public int getInnovation() {
		return innovation;
	}

	/**
	 * @param innovation
	 *            the innovation to set
	 */
	public void setInnovation(int innovation) {
		this.innovation = innovation;
	}

	/**
	 * @return the teamwork
	 */
	public int getTeamwork() {
		return teamwork;
	}

	/**
	 * @param teamwork
	 *            the teamwork to set
	 */
	public void setTeamwork(int teamwork) {
		this.teamwork = teamwork;
	}

	/**
	 * @return the communication
	 */
	public int getCommunication() {
		return communication;
	}

	/**
	 * @param communication
	 *            the communication to set
	 */
	public void setCommunication(int communication) {
		this.communication = communication;
	}

	/**
	 * @return the strain
	 */
	public int getStrain() {
		return strain;
	}

	/**
	 * @param strain
	 *            the strain to set
	 */
	public void setStrain(int strain) {
		this.strain = strain;
	}

	/**
	 * @return the details
	 */
	public int getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(int details) {
		this.details = details;
	}

	/**
	 * @return the potential
	 */
	public int getPotential() {
		return potential;
	}

	/**
	 * @param potential
	 *            the potential to set
	 */
	public void setPotential(int potential) {
		this.potential = potential;
	}

	/**
	 * @return the choice
	 */
	public int getChoice() {
		return choice;
	}

	/**
	 * @param choice the choice to set
	 */
	public void setChoice(int choice) {
		this.choice = choice;
	}

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
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}