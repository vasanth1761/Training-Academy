package com.academy.model;

public class ResultTable {
	int id;
	String name;
	String course;
	int score;
	double percentage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int correctCount) {
		this.score = correctCount;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public ResultTable(int id, String name, String course, int score, double percentage) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.score = score;
		this.percentage = percentage;
	}
	public ResultTable() {

	}
	

}
