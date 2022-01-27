package com.efunzo.services.epellation.domaine;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "spelling_session_item")
public class SpellingSessionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private SpellingSession spellingSession;

	@ManyToOne
	private SpellingWord spellingWord;

	private String response;

	private Instant createdDate = Instant.now();

	private Instant updatedDate = Instant.now();


	public SpellingSessionItem() {
		super();
	}

	public SpellingSessionItem(SpellingWord spellingWord, String response,
			Instant updatedDate, Instant createdDate) {
		this.spellingWord = spellingWord;
		this.response = response;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}
	
	public SpellingSessionItem(SpellingWord spellingWord,
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


	public SpellingSession getSpellingSession() {
		return spellingSession;
	}

	public void setSpellingSession(SpellingSession spellingSession) {
		this.spellingSession = spellingSession;
	}


	public SpellingWord getSpellingWord() {
		return spellingWord;
	}

	public void setSpellingWord(SpellingWord spellingWord) {
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
				+ spellingWord + ", response=" + response + ", createdDade=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}


}