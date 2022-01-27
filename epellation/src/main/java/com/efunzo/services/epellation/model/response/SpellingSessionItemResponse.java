package com.efunzo.services.epellation.model.response;


import java.time.Instant;

public class SpellingSessionItemResponse {
	
    private Long spellingWordId;
	
	private String word;
	
	private  String inPhrase;
	
	private String definition;
	
	private String response;
	
	private Instant updatedDate;

	public Long getSpellingWordId() {
		return spellingWordId;
	}

	public void setSpellingWordId(Long spellingWordId) {
		this.spellingWordId = spellingWordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getInPhrase() {
		return inPhrase;
	}

	public void setInPhrase(String inPhrase) {
		this.inPhrase = inPhrase;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	

}
