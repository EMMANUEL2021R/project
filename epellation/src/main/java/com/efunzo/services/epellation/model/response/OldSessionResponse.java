package com.efunzo.services.epellation.model.response;

import java.util.List;

import com.efunzo.services.epellation.domaine.SpellingWord;

public class OldSessionResponse {
	
	private List<SpellingWord> spellingWords;

	public List<SpellingWord> getSpellingWords() {
		return spellingWords;
	}

	public void setSpellingWords(List<SpellingWord> spellingWords) {
		this.spellingWords = spellingWords;
	}

}
