package com.efunzo.services.epellation.model.response;

import java.time.Instant; 
import java.util.List;

public class SpellingSessionResponse {
	
	private Long spellingSessionId;
	private Instant date;
	private List<SpellingSessionItemResponse> spellingSessionItemResponses;
	
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
	
	
	
	

}
