package com.efunzo.services.epellation.model.response;

import java.util.List;

import com.efunzo.services.epellation.service.dto.SpellingWordDTO;

public class EpellationSessionResponse {
	
	private List<SpellingWordDTO> spellingWords;

	public List<SpellingWordDTO> getSpellingWords() {
		return spellingWords;
	}

	public void setSpellingWords(List<SpellingWordDTO> spellingWords) {
		this.spellingWords = spellingWords;
	}

}
