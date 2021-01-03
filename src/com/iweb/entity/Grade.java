package com.iweb.entity;
public class Grade {
	private int uid;
	private String uname;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private int grade;
	private int testId;
	private String beginTime;
	private String usedTime;
	public Grade(){
		uid=0;
		uname="";
		testId=0;
		grade=0;
		beginTime="";
		usedTime="";
		email="";
	}
	public Grade(int id1,String name,int marks,int id2,String time1,String time2,String mail){
		uid=id1;
		uname=name;
		grade=marks;
		testId=id2;
		beginTime=time1;
		usedTime=time2;
		email=mail;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
