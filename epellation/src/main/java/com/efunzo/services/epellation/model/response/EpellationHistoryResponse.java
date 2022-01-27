package com.efunzo.services.epellation.model.response;

import java.util.List;

public class EpellationHistoryResponse {
	
	private List<SpellingSessionResponse> spellingSessionResponses;

	public List<SpellingSessionResponse> getSpellingSessionResponses() {
		return spellingSessionResponses;
	}

	public void setSpellingSessionResponses(List<SpellingSessionResponse> spellingSessionResponses) {
		this.spellingSessionResponses = spellingSessionResponses;
	}
	
	
	
}
