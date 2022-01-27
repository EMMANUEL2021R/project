package com.efunzo.services.epellation.service.dto;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.efunzo.services.epellation.domaine.SpellingWord;


public class SpellingSessionItemDTO {

	private Long id;

	private SpellingSessionDTO spellingSession;


	private SpellingWordDTO spellingWord;

	private String response;

	private Instant createdDate = Instant.now();

	private Instant updatedDate = Instant.now();
	
	
	public SpellingSessionItemDTO() {
		super();
	}

	public SpellingSessionItemDTO(SpellingWordDTO spellingWord, String response,
			Instant updatedDate, Instant createdDate) {
		this.spellingWord = spellingWord;
		this.response = response;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}
	
	public SpellingSessionItemDTO(SpellingWordDTO spellingWord,
			Instant updatedDate, Instant createdDate) {
		this.spellingWord = spellingWord;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public SpellingSessionDTO getSpellingSession() {
		return spellingSession;
	}

	public void setSpellingSession(SpellingSessionDTO spellingSession) {
		this.spellingSession = spellingSession;
	}


	public SpellingWordDTO getSpellingWord() {
		return spellingWord;
	}

	public void setSpellingWord(SpellingWordDTO spellingWord) {
		this.spellingWord = spellingWord;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Instant getCreatedDade() {
		return createdDate;
	}

	public void setCreatedDade(Instant createdDade) {
		this.createdDate = createdDade;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Override
	public String toString() {
		return "SpellingSessionItem [id=" + id + ", spellingSession=" + spellingSession + ", spellingWord="
				+ spellingWord+ ", response=" + response + ", createdDade=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}


}