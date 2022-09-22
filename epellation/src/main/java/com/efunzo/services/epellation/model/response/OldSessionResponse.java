package com.efunzo.services.epellation.model.response;

import java.util.List;

import com.efunzo.services.epellation.domaine.SpellingWord;

public class OldSessionResponse {
	
	private Long sessionId;
	
	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	private List<SpellingWord> spellingWords;

	public List<SpellingWord> getSpellingWords() {
		return spellingWords;
	}

	public void setSpellingWords(List<SpellingWord> spellingWords) {
		this.spellingWords = spellingWords;
	}

}
