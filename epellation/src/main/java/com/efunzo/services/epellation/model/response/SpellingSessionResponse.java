package com.efunzo.services.epellation.model.response;

import java.time.Instant; 
import java.util.List;

import com.fasterxml.jackson.databind.ser.AnyGetterWriter;

public class SpellingSessionResponse {
	
	private Long spellingSessionId;
	private Instant date;
	private List<SpellingSessionItemResponse> spellingSessionItemResponses;
    private String score;


	public Long getSpellingSessionId() {
		return spellingSessionId;
	}
	public void setSpellingSessionId(Long spellingSessionId) {
		this.spellingSessionId = spellingSessionId;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public List<SpellingSessionItemResponse> getSpellingSessionItemResponses() {
		return spellingSessionItemResponses;
	}
	public void setSpellingSessionItemResponses(List<SpellingSessionItemResponse> spellingSessionItemResponses) {
		this.spellingSessionItemResponses = spellingSessionItemResponses;
	}

	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

}
