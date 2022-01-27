package com.efunzo.services.epellation.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.efunzo.services.epellation.domaine.GradeType;
import com.efunzo.services.epellation.domaine.Level;
import com.efunzo.services.epellation.domaine.SpellingWord;
import com.efunzo.services.epellation.model.request.AddSpellingWordDataRequest;
import com.efunzo.services.epellation.model.request.AddWordRequest;
import com.efunzo.services.epellation.model.response.AddWordResponse;
import com.efunzo.services.epellation.repository.SpellingWordRepository;
import com.efunzo.services.epellation.service.dto.LevelDTO;
import com.efunzo.services.epellation.service.dto.SpellingWordDTO;
import com.efunzo.services.epellation.service.mapper.LevelMapper;
import com.efunzo.services.epellation.service.mapper.SpellingWordMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SpellingWordService {
	
	
private final Logger log = LoggerFactory.getLogger(SpellingWordService.class);
	
	@Autowired
	private SpellingWordRepository spellingWordRepository;
	
	@Autowired
	private LevelService levelService;
	
	@Autowired
	private SpellingWordMapper spellingWordMapper;
	
	@Autowired
	private LevelMapper levelMapper;
	
	
	public SpellingWordDTO addSpellingWord(SpellingWordDTO spellingWord) {		
		
		SpellingWord savedSpellingWord= spellingWordRepository.save(spellingWordMapper.toEntity(spellingWord));
		
		log.info("Saved spellingWord {} ---> ", savedSpellingWord );
		
		return spellingWordMapper.toDto(savedSpellingWord);
	}

	public List<SpellingWordDTO> addManySpellingWord(List<SpellingWordDTO> spellingWords) {
		
		List<SpellingWordDTO> savedSpellingWords = new ArrayList<>();
		
		for (SpellingWordDTO spellingWord: spellingWords) {
			
			SpellingWordDTO savedSpellingWord =  addSpellingWord(spellingWord);
			
			savedSpellingWords.add(savedSpellingWord);
		}
		
		return savedSpellingWords;
	}

   public SpellingWordDTO findSpellingWordById(Long id) {
		
		Optional<SpellingWord> spellingWord = spellingWordRepository.findSpellingWordById(id);
		
		log.info("Retrived spellingWord {} ===> ", spellingWord );
		
		if(spellingWord.isPresent()) {
			
			return spellingWordMapper.toDto(spellingWord.get());
		}
		
		return null;
	}

	public List<SpellingWordDTO> findAll() {
	
		List<SpellingWord>  allSpellingWords = spellingWordRepository.findAll();
		
		log.info("Retrived spellingWords {} ===> ", allSpellingWords );
		
		
		return spellingWordMapper.toDto(allSpellingWords);
	}

	public AddWordResponse addSpellingWord(AddWordRequest addWordRequest) {
		
		List<Level> levels = levelMapper.toEntity(levelService.findByIds(addWordRequest.getLevels()));
		
		SpellingWord spellingWord = new SpellingWord();
		
		spellingWord.setDefinition(addWordRequest.getDefinition());
		spellingWord.setInPhrase(addWordRequest.getInPhrase());
		spellingWord.setWord(addWordRequest.getWord());
		spellingWord.setLevels(levels);
		
		spellingWord = spellingWordRepository.save(spellingWord);
		
		log.info("Saved spellingWord {} ---> ", spellingWord );
		
		AddWordResponse response = new AddWordResponse();
		
		response.setWord(spellingWord.getWord());
		response.setInPhrase(spellingWord.getInPhrase());
		response.setDefinition(spellingWord.getDefinition());
		
		List<Long> levelIds = spellingWord.getLevels().stream()
				.map(l -> l.getId())
				.collect(Collectors.toList());
		
		response.setLevels(levelIds);
		
		return response;
	}
	
	public List<SpellingWordDTO> findSpellingWordByLevelNumber(Integer number, GradeType grade) {
		
		List<SpellingWord> 	allSpellingWords = spellingWordRepository.findSpellingWordByLevels_NumberAndLevels_Grade(number, grade);
		
			return spellingWordMapper.toDto(allSpellingWords);

	}

	public List<SpellingWordDTO> findSpellingWordByLevels_Number(Integer level) {
		
		List<SpellingWord> 	allSpellingWords = spellingWordRepository.findSpellingWordByLevels_Number(level);
		
			return spellingWordMapper.toDto(allSpellingWords);
	
	}

	public List<AddWordResponse> addSpellingWordList(List<AddWordRequest> addWordRequests) {
		
		List<AddWordResponse> addedResponses = new ArrayList<>();
		
		for(AddWordRequest addWordRequest:addWordRequests) {

			List<Level> levels = levelMapper.toEntity(levelService.findByIds(addWordRequest.getLevels()));
			
			SpellingWord spellingWord = new SpellingWord();
			
			spellingWord.setDefinition(addWordRequest.getDefinition());
			spellingWord.setInPhrase(addWordRequest.getInPhrase());
			spellingWord.setWord(addWordRequest.getWord());
			spellingWord.setLevels(levels);
			
			spellingWord = spellingWordRepository.save(spellingWord);
			
			log.info("Saved spellingWord {} ---> ", spellingWord );
			
			AddWordResponse response = new AddWordResponse();
			
			response.setWord(spellingWord.getWord());
			response.setInPhrase(spellingWord.getInPhrase());
			response.setDefinition(spellingWord.getDefinition());

			
			List<Long> levelIds = spellingWord.getLevels().stream()
					.map(l -> l.getId())
					.collect(Collectors.toList());
			
			response.setLevels(levelIds);
			
			addedResponses.add(response);
		}
		
		return addedResponses;
		
	}

	public SpellingWordDTO updateSpellingWord(SpellingWordDTO spellingWord) {
		
		SpellingWord savedSpellingWord= spellingWordRepository.save(spellingWordMapper.toEntity(spellingWord));
		
		log.info("Saved spellingWord {} ---> ", savedSpellingWord );
		
		return spellingWordMapper.toDto(savedSpellingWord);
	}

	public void deleteSpellingWord(Long id) {
		
		spellingWordRepository.deleteById(id);
		log.info("Deleted spellingWord id {} ---> ", id );
	}
	
	public List<SpellingWordDTO> addSpellingWordData(List<AddSpellingWordDataRequest> addSpellingWordDataRequests) {
		
		List<SpellingWordDTO> AddWords = new ArrayList<>();
		
		for(AddSpellingWordDataRequest addSpellingWordDataRequest:addSpellingWordDataRequests) {
			
			List<LevelDTO> searchedLevels = levelService.searchLevels(addSpellingWordDataRequest.getFromJsonLevels());
			
			SpellingWordDTO spellingWordDTO = new SpellingWordDTO();
			
			spellingWordDTO.setDefinition(addSpellingWordDataRequest.getDefinition());
			spellingWordDTO.setInPhrase(addSpellingWordDataRequest.getInPhrase());
			spellingWordDTO.setWord(addSpellingWordDataRequest.getWord());
			spellingWordDTO.setLevels(searchedLevels);
			
			SpellingWordDTO addSpellingWord = addSpellingWord(spellingWordDTO);
			
			AddWords.add(addSpellingWord);
		}
		return AddWords;
	}

	public List<SpellingWordDTO> inputSpellingWordDataJson(MultipartFile file) {
		
		List<SpellingWordDTO> addSpellingWord = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		TypeReference<List<SpellingWordDTO>> typeReference = new TypeReference<List<SpellingWordDTO>>(){};
		
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		try {
			List<SpellingWordDTO> spellingWords = mapper.readValue(inputStream,typeReference);
			
			addSpellingWord = addManySpellingWord(spellingWords);
			
			return addSpellingWord;
			
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
		return null;
		
	}
	
	public List<SpellingWordDTO> addSpellingWordDataCsv(List<AddSpellingWordDataRequest> addSpellingWordDataRequests) {

		List<SpellingWordDTO> listWords = new ArrayList<>();

		for(AddSpellingWordDataRequest addSpellingWordDataRequest:addSpellingWordDataRequests) {

			List<String> addLevelIds = addSpellingWordDataRequest.getFromCsvLevels();
			
			List<LevelDTO> levels = new ArrayList<>();

			for(String levelId:addLevelIds ) {
				
				String levelids =addLevelIds.get(0) ;
				
				String[] ls = levelids.split(" ");
				
			for(String ls1:ls ) {
				
   			 levels.add(levelService.findlevelwhithnumberGrade(Character.getNumericValue(ls1.charAt(0)) , getGradeType(ls1.charAt(1))));
			}

			}
			SpellingWordDTO spellingWord = new SpellingWordDTO();
			
			spellingWord.setDefinition(addSpellingWordDataRequest.getDefinition());
			spellingWord.setInPhrase(addSpellingWordDataRequest.getInPhrase());
			spellingWord.setWord(addSpellingWordDataRequest.getWord());
			spellingWord.setLevels(levels);

			SpellingWordDTO addSpellingWord = addSpellingWord(spellingWord);
			
			listWords.add(addSpellingWord);
			}
			return listWords;
	}

	public List<SpellingWordDTO> inputSpellingWordDataCSV(MultipartFile fileInput) throws IOException  {
			
		List<SpellingWordDTO> addSpellingWord = new ArrayList<>();
				
	  CsvMapper mapper = new CsvMapper();
	  
	  CsvSchema schema = mapper.schemaFor(AddSpellingWordDataRequest.class).withHeader().withColumnReordering(true);
	    ObjectReader reader =  mapper.readerFor(AddSpellingWordDataRequest.class).with(schema);
	        
	        addSpellingWord = addSpellingWordDataCsv(reader.<AddSpellingWordDataRequest>readValues(fileInput.getInputStream()).readAll());
	      
			return addSpellingWord;
	        }
	
	private GradeType getGradeType(char c) {
		
		if(c=='H') {
			
			return GradeType.HIGHT ;
		}else
			if(c=='M') {
				
				return GradeType.MEDIUM ;
		}else
			if(c=='L') {
				
				return GradeType.LOW ;
		}else
			return null ;
						
		}	
	}
		