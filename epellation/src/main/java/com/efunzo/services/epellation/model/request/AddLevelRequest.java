package com.efunzo.services.epellation.model.request;

import com.efunzo.services.epellation.domaine.GradeType;

public class AddLevelRequest {

  private Integer grade;
	
  private  GradeType dificulty;

	public AddLevelRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public GradeType getDificulty() {
		return dificulty;
	}

	public void setDificulty(GradeType dificulty) {
		this.dificulty = dificulty;
	}

}

