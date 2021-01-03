package com.iweb.entity;

public class Teacher {
	private int Tid;
	private String Tno;//教师编号
	private String passWord;
	private String Tname;
	private String Tsex;
	private String Tphone;
	private String Temail;
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTsex() {
		return Tsex;
	}
	public void setTsex(String tsex) {
		Tsex = tsex;
	}
	public String getTphone() {
		return Tphone;
	}
	public void setTphone(String tphone) {
		Tphone = tphone;
	}
	public String getTemail() {
		return Temail;
	}
	public void setTemail(String temail) {
		Temail = temail;
	}
	public Teacher() {
		Tid=0;
		Tno="";
		passWord="";
		Tname="";
		Tsex="";
		Tphone="";
		Temail="";
	}
	public Teacher(int Tid,String Tno,String password,String Tname,String Tsex,String Tphone,String Temail) {
		this.Tid=Tid;
		this.Tno=Tno;
		this.passWord=password;
		this.Tname=Tname;
		this.Tsex=Tsex;
		this.Tphone=Tphone;
		this.Temail=Temail;
	}
}
