package com.efunzo.services.epellation.model.response;

import java.util.ArrayList;
import java.util.List;

public class AddWordResponse {
	
	
	private String word;
	
	private  String inPhrase;
	
	private String definition;

	private List<Long> levels = new ArrayList<>();

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

	public List<Long> getLevels() {
		return levels;
	}

	public void setLevels(List<Long> levelIds) {
		this.levels = levelIds;
	}
	
	

}
