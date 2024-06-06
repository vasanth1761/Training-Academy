package com.academy.model;

public class courseP {
 int courseid;
 String CourseName;
 String paymentType;
 long AccoutNumber;
 String date;
 int amount;
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public String getCourseName() {
	return CourseName;
}
public void setCourseName(String courseName) {
	CourseName = courseName;
}
public String getPaymentType() {
	return paymentType;
}
public void setPaymentType(String paymentType) {
	this.paymentType = paymentType;
}
public long getAccoutNumber() {
	return AccoutNumber;
}
public void setAccoutNumber(long accoutNumber) {
	AccoutNumber = accoutNumber;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public courseP(int courseid, String courseName, String paymentType, long accoutNumber, String date, int amount) {
	super();
	this.courseid = courseid;
	CourseName = courseName;
	this.paymentType = paymentType;
	AccoutNumber = accoutNumber;
	this.date = date;
	this.amount = amount;
}
public courseP() {
	// TODO Auto-generated constructor stub
}
}
