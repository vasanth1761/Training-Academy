package com.academy.model;

public class resultP {
	String learnerid;
	String learnername;
	String cousename;
	String attemptedquestion;
	String correctanswer;
	int percentage;
	public resultP(String learnerid, String learnername, String cousename, String attemptedquestion,
			String correctanswer, int percentage) {
		super();
		this.learnerid = learnerid;
		this.learnername = learnername;
		this.cousename = cousename;
		this.attemptedquestion = attemptedquestion;
		this.correctanswer = correctanswer;
		this.percentage = percentage;
	}
	public resultP(int id, String name, String course, int totalCount, int correctCount, double percentage) {
		// TODO Auto-generated constructor stub
	}
	public String getLearnerid() {
		return learnerid;
	}
	public void setLearnerid(String learnerid) {
		this.learnerid = learnerid;
	}
	public String getLearnername() {
		return learnername;
	}
	public void setLearnername(String learnername) {
		this.learnername = learnername;
	}
	public String getCousename() {
		return cousename;
	}
	public void setCousename(String cousename) {
		this.cousename = cousename;
	}
	public String getAttemptedquestion() {
		return attemptedquestion;
	}
	public void setAttemptedquestion(String attemptedquestion) {
		this.attemptedquestion = attemptedquestion;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

}
