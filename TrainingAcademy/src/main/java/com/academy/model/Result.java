package com.academy.model;

public class Result {
	int learnerid;
	String learnername;
	String cousename;
	String attemptedquestion;
	int correctanswer;
	double percentage;
	String comments;
	public Result(int learnerid, String learnername, String cousename, String attemptedquestion, int correctanswer,
			double percentage, String comments) {
		super();
		this.learnerid = learnerid;
		this.learnername = learnername;
		this.cousename = cousename;
		this.attemptedquestion = attemptedquestion;
		this.correctanswer = correctanswer;
		this.percentage = percentage;
		this.comments = comments;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Result(int id, String name, String course, int totalCount, int correctCount, double percentage) {

	}
	public Result() {

	}
	public int getLearnerid() {
		return learnerid;
	}
	public void setLearnerid(int learnerid) {
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
	public int getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(int correctCount) {
		this.correctanswer = correctCount;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
