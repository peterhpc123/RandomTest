package com.iweb.entity;

public class Paper {
	private int paperId;
	
	private int totalTime;
	public Paper(int i,int j){
		paperId=i;
		totalTime=j;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
}
