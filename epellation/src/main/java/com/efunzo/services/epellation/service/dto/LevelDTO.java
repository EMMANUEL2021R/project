package com.efunzo.services.epellation.service.dto;

import com.efunzo.services.epellation.domaine.GradeType;
import com.efunzo.services.epellation.domaine.Level;

public class LevelDTO {

	private Long id;
	
	private Integer number;
	
	private String description;

	private GradeType grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GradeType getGrade() {
		return grade;
	}

	public void setGrade(GradeType grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Level [id=" + id + ", number=" + number + ", description=" + description + ", grade=" + grade + "]";
	}
    
}
