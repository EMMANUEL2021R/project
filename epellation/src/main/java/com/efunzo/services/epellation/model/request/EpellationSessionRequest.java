package com.efunzo.services.epellation.model.request;

public class EpellationSessionRequest {
	
	//level of difficulty in the session levels are : LOW, HIGHT, MEDIUM, MIXT
	private Integer level;
	private String studentGrade;
	
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	
	
	
	

}
