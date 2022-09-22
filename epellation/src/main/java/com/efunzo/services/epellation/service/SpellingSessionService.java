package com.efunzo.services.epellation.service;

import com.efunzo.services.epellation.domaine.SpellingSession;
import com.efunzo.services.epellation.domaine.SpellingSessionItem;
import com.efunzo.services.epellation.domaine.SpellingWord;
import com.efunzo.services.epellation.model.response.OldSessionResponse;
import com.efunzo.services.epellation.model.response.SpellingSessionItemResponse;
import com.efunzo.services.epellation.model.response.SpellingSessionResponse;
import com.efunzo.services.epellation.repository.SpellingSessionItemRepository;
import com.efunzo.services.epellation.repository.SpellingSessionRepository;
import com.efunzo.services.epellation.service.dto.SpellingSessionDTO;
import com.efunzo.services.epellation.service.dto.SpellingSessionItemDTO;
import com.efunzo.services.epellation.service.mapper.SpellingSessionItemMapper;
import com.efunzo.services.epellation.service.mapper.SpellingSessionMapper;
import com.efunzo.services.epellation.service.mapper.SpellingWordMapper;

import com.efunzo.services.epellation.domaine.SpellingWord;
import com.efunzo.services.epellation.model.response.OldSessionResponse;
import com.efunzo.services.epellation.model.response.SpellingSessionItemResponse;
import com.efunzo.services.epellation.repository.SpellingSessionItemRepository;
import com.efunzo.services.epellation.repository.SpellingSessionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class SpellingSessionService {
	
private final Logger log = LoggerFactory.getLogger(SpellingSessionService.class);
	
	@Autowired
	private SpellingSessionItemService spellingSessionItemService;
	
	@Autowired
	private SpellingSessionItemRepository spellingSessionItemRepository;
	
	@Autowired
	private SpellingSessionRepository spellingSessionRepository;       

	
	@Autowired
	private SpellingSessionItemRepository spellingSessiontemRepository;
	
	@Autowired
	private EpellationUserService epellationUserService;
	
	@Autowired
	private SpellingSessionMapper spellingSessionMapper;

	@Autowired
	private SpellingSessionItemMapper spellingSessionItemMapper;
	
	@Autowired
	private SpellingWordMapper spellingWordMapper;
	
	public SpellingSessionItemDTO updatespellingSessionItemresponse(Long spellingSessionid, Long spellingWordid,
			String response) {
		
		Optional<SpellingSessionItem>  spellingSessionItem = spellingSessionItemRepository.findSpellingSessionItemBySpellingSession_IdAndSpellingWord_Id(spellingSessionid, spellingWordid);

		if(spellingSessionItem.isPresent()) {
			
			SpellingSessionItem finespellingSessionItem	=spellingSessionItem.get();
			
			finespellingSessionItem.setUpdatedDate(Instant.now());
			
			finespellingSessionItem.setResponse(response);
			
			spellingSessionItemService.addSpellingSessionItem(spellingSessionItemMapper.toDto(finespellingSessionItem));
			
		 return spellingSessionItemMapper.toDto(finespellingSessionItem);
		}
		else
			return null;
		}

	public SpellingSessionDTO addSpellingSession(SpellingSessionDTO spellingSession) {
		
		SpellingSession savedSpellingSession = spellingSessionRepository.save(spellingSessionMapper.toEntity(spellingSession) );
			
			log.info("Saved spellingSession {} ===> ", savedSpellingSession );
			
			return spellingSessionMapper.toDto(savedSpellingSession);
		}
	
	
	public List<SpellingSessionResponse> getSpellingHistory(Long userId) {
		
		List<SpellingSession> allSpellingSessions = spellingSessionRepository.findSpellingSessionByEpellationUser_Id(userId);
		
		log.info("Saved allSpellingSessions {} ===> ", allSpellingSessions );
		
		List<SpellingSessionResponse> allSpellingSessionResponses = new ArrayList<>();
		
		if(allSpellingSessions.size() > 0) {
			for(SpellingSession spellingSession : allSpellingSessions ) {

				SpellingSessionResponse response = new SpellingSessionResponse();
				response.setDate(spellingSession.getCreatedDade());
				response.setSpellingSessionId(spellingSession.getId());

				
				List<SpellingSessionItemResponse>  responses = spellingSessionItemService.findSpellingSessionItemBySpellingSession_Id(spellingSession.getId());
				
				response.setSpellingSessionItemResponses(responses);
				response.setScore(calculateScore(responses));


				allSpellingSessionResponses.add(response);
			}
		}
		
		return allSpellingSessionResponses;
	}
	
	
public OldSessionResponse getAnOldSession (Long sessionId, Long userId) {
		
		OldSessionResponse oldSessionResponse = new OldSessionResponse();
		
		List<SpellingSessionItem> spellingSessionItems = spellingSessiontemRepository.findSpellingSessionItemBySpellingSession_Id(sessionId);
			
			List<SpellingWord> words = spellingSessionItems.stream()
														  .map(ssi -> ssi.getSpellingWord())
														  .collect(Collectors.toList());
			
			oldSessionResponse.setSpellingWords(words);
			
			log.info("Getted old Spelling Sesson {} ===> ", oldSessionResponse );
			
			SpellingSessionDTO spellingSession = epellationUserService.createSpellingSession(userId, spellingWordMapper.toDto(words));
			
			oldSessionResponse.setSessionId(spellingSession.getId());
			
			return oldSessionResponse;
	}

 public SpellingSessionResponse getSpellingSessionResult(Long sessionId) {
	 
	 
	 Optional<SpellingSession> seOptional = spellingSessionRepository.findById(sessionId);
	 SpellingSessionResponse sessionResponse = new SpellingSessionResponse();
	 
	 if(seOptional.isPresent()) {
		 
		List<SpellingSessionItemResponse>  responses = spellingSessionItemService.findSpellingSessionItemBySpellingSession_Id(sessionId);
		
		sessionResponse.setDate(seOptional.get().getCreatedDade());
		sessionResponse.setSpellingSessionId(sessionId);
		sessionResponse.setSpellingSessionItemResponses(responses);
		sessionResponse.setScore(calculateScore(responses));
		
	 }
	
	return sessionResponse;
}
	
	
private String calculateScore(List<SpellingSessionItemResponse> spellingSessionItemResponses) {
	
	double total = spellingSessionItemResponses.size();
	double correct = 0.0;
	
	for (SpellingSessionItemResponse sessionItemResponse: spellingSessionItemResponses) {
		
		if(sessionItemResponse.getWord().equalsIgnoreCase(sessionItemResponse.getResponse())) {
			
			correct = correct + 1;
		}
	}
	
	return total!=0.0?( (correct / total) * 100) +"%": "0.0%";
}

}

