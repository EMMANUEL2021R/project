package com.efunzo.services.epellation.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efunzo.services.epellation.domaine.SpellingSessionItem;
import com.efunzo.services.epellation.model.response.SpellingSessionItemResponse;
import com.efunzo.services.epellation.repository.SpellingSessionItemRepository;
import com.efunzo.services.epellation.service.dto.SpellingSessionItemDTO;
import com.efunzo.services.epellation.service.mapper.SpellingSessionItemMapper;

@Service
public class SpellingSessionItemService {

    private final Logger log = LoggerFactory.getLogger(SpellingSessionItemService.class);

	@Autowired
	private SpellingSessionItemRepository spellingSessionItemRepository;
	
	@Autowired
	private SpellingSessionItemMapper spellingSessionItemMapper;
		
	public SpellingSessionItemDTO addSpellingSessionItem(SpellingSessionItemDTO spellingSessionItem) {

		SpellingSessionItem savedSpellingSessionItem = spellingSessionItemRepository.save(spellingSessionItemMapper.toEntity(spellingSessionItem));
			
			log.info("Saved spellingSession {} ===> ", savedSpellingSessionItem );
			
			return spellingSessionItemMapper.toDto(savedSpellingSessionItem);
		}
	
	
	public List<SpellingSessionItemResponse>  findSpellingSessionItemBySpellingSession_Id(Long spellingSessionId){
		
		List<SpellingSessionItem> allSpellingSessionItems = spellingSessionItemRepository.findSpellingSessionItemBySpellingSession_Id(spellingSessionId);
		
		log.info("Retrived allSpellingSessionItems {} ===> ", allSpellingSessionItems );
		
		List<SpellingSessionItemResponse> responseItems = new ArrayList<>();
		
		if(allSpellingSessionItems.size() > 0) {
			for(SpellingSessionItem spellingSessionItem : allSpellingSessionItems ) {
				SpellingSessionItemResponse responseItem = new SpellingSessionItemResponse();
				responseItem.setResponse(spellingSessionItem.getResponse());
				responseItem.setDefinition(spellingSessionItem.getSpellingWord().getDefinition());
				responseItem.setInPhrase(spellingSessionItem.getSpellingWord().getInPhrase());
				responseItem.setWord(spellingSessionItem.getSpellingWord().getWord());
				responseItem.setSpellingWordId(spellingSessionItem.getSpellingWord().getId());
				responseItem.setUpdatedDate(spellingSessionItem.getUpdatedDate());
				
				responseItems.add(responseItem);
			}
		}	
	     return responseItems;
	}


}
