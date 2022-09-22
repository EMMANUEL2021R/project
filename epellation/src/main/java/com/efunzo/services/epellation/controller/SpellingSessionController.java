package com.efunzo.services.epellation.controller;

import com.efunzo.services.epellation.model.response.OldSessionResponse;
import com.efunzo.services.epellation.model.response.SpellingSessionResponse;
import com.efunzo.services.epellation.service.SpellingSessionService;
import com.efunzo.services.epellation.service.dto.SpellingSessionItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.efunzo.services.epellation.model.response.OldSessionResponse;
import com.efunzo.services.epellation.model.response.SpellingSessionItemResponse;
import com.efunzo.services.epellation.model.response.SpellingSessionResponse;
import com.efunzo.services.epellation.service.SpellingSessionService;
import com.efunzo.services.epellation.service.dto.SpellingSessionItemDTO;
import java.util.List;


@Controller
public class SpellingSessionController {
	
	@Autowired
	private SpellingSessionService spellingSessionService;

	@GetMapping("/api/epellation/restart-session/session/{session_id}/user/{user_id}")
	public ResponseEntity<OldSessionResponse> restartOldSession(@PathVariable(name="session_id") Long sessionId, @PathVariable(name="user_id") Long userId){
		
		 OldSessionResponse oldSessionResponse = spellingSessionService.getAnOldSession(sessionId, userId);
		return ResponseEntity.status(HttpStatus.OK).body(oldSessionResponse);
	 }
	
	@GetMapping("/api/history/user/{user-id}")
	public ResponseEntity<List<SpellingSessionResponse>> getSpellingHistory(@PathVariable(name="user-id") Long userId){
		
		List<SpellingSessionResponse> historyResponse = spellingSessionService.getSpellingHistory(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(historyResponse);
		
	}

	@PostMapping("/api/spellingsessionid/{spellingsessionid}/spellingwordid/{spellingwordid}/response/{response}")
	public ResponseEntity<SpellingSessionItemDTO> updatespellingSessionItemresponse(@PathVariable(name="spellingsessionid") Long spellingsessionid, @PathVariable(name="spellingwordid") Long spellingwordid,@PathVariable(name="response") String response ){
		
		SpellingSessionItemDTO updatedspellingSessionItem = spellingSessionService.updatespellingSessionItemresponse(spellingsessionid,spellingwordid, response);
		return ResponseEntity.status(HttpStatus.OK).body(updatedspellingSessionItem);

	}
	

	@GetMapping("/api/result/session/{session_id}")
	public ResponseEntity<SpellingSessionResponse> getSpellingSessionResult(@PathVariable(name="session_id") Long sessionId){
		
		SpellingSessionResponse result = spellingSessionService.getSpellingSessionResult(sessionId);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	



}
