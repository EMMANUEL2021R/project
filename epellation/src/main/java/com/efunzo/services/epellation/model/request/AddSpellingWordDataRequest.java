package com.efunzo.services.epellation.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AddSpellingWordDataRequest {


	private String word;

	private  String inPhrase;

	private String definition;

	private List<String> fromCsvLevels = new ArrayList<>();

	private List<AddLevelRequest> fromJsonLevels = new ArrayList<>();

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

	public List<String> getFromCsvLevels() {
		return fromCsvLevels;
	}

	public void setFromCsvLevels(List<String> fromCsvLevels) {
		this.fromCsvLevels = fromCsvLevels;
	}

	public List<AddLevelRequest> getFromJsonLevels() {
		return fromJsonLevels;
	}

	public void setFromJsonLevels(List<AddLevelRequest> fromJsonLevels) {
		this.fromJsonLevels = fromJsonLevels;
	}


}
