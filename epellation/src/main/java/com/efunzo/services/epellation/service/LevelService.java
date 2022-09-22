package com.efunzo.services.epellation.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.efunzo.services.epellation.domaine.GradeType;
import com.efunzo.services.epellation.domaine.Level;
import com.efunzo.services.epellation.model.request.AddLevelRequest;
import com.efunzo.services.epellation.repository.LevelRepository;
import com.efunzo.services.epellation.service.dto.LevelDTO;
import com.efunzo.services.epellation.service.mapper.LevelMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class LevelService {
	
private final Logger log = LoggerFactory.getLogger(LevelService.class);
	
	@Autowired
	private LevelRepository levelRepository;
	
	@Autowired
	private LevelMapper levelMapper;


	public LevelDTO addLevel(LevelDTO level) {
		
		Level savedLevel= levelRepository.save(levelMapper.toEntity(level));
		
		log.info("Saved level {} ===> ", savedLevel );
		
		return levelMapper.toDto(savedLevel);
	}

	public List<LevelDTO> addManyLevel(List<LevelDTO> levels) {
		
		List<LevelDTO> savedLevels = new ArrayList<>();
		
		for (LevelDTO level: levels) {
			
			LevelDTO savedLevel =  addLevel(level);
			
			savedLevels.add(savedLevel);
		}
		
		return savedLevels;
	}

	public LevelDTO findLevelById(Long id) {
		
		Optional<Level> level = levelRepository.findLevelById(id);
		
		log.info("Retrived level {} ===> ", level );
		
		if(level.isPresent()) {
			
		return levelMapper.toDto(level.get()) ;
		}
		
		return null;
	}

	public List<LevelDTO> findAll() {
	
		List<Level>  allLevels = levelRepository.findAll();
		
		log.info("Retrived levels {} ===> ", allLevels );
		
		List<LevelDTO> levelDTOs = levelMapper.toDto(allLevels);
		
		return levelDTOs;
	}
	
	
	public List<LevelDTO> findByIds(List<Long> list) {
		
		List<Level>  allLevels = levelRepository.findAllById(list);
		
		log.info("Retrived levels {} ===> ", allLevels );
		
		return levelMapper.toDto(allLevels) ;
	}
	
	

	public Level findByNumber(Integer number) {
		
		Optional<Level>  allLevels = levelRepository.findLevelByNumber(number);
		
		log.info("Retrived levels {} ===> ", allLevels );
		
		return  allLevels.get();
	}

	public LevelDTO updateLevel(Level level) {

		Level savedLevel= levelRepository.save(level);
		
		log.info("Saved level {} ===> ", savedLevel );
		
		return levelMapper.toDto(savedLevel) ;
	}
	
	public void deleteLevel(Long id) {
		
		levelRepository.deleteById(id);
		
		log.info("Dellete Level by Id {} ===> ", id );
	}

	public List<LevelDTO> searchLevels(List<AddLevelRequest> levelParams){

		List<LevelDTO> levels = new ArrayList<>();

		for(AddLevelRequest addLevelRequest:levelParams) {
			
			
			Optional<Level>  levelOptional = levelRepository.findLevelBynumberAndGrade(addLevelRequest.getGrade(), addLevelRequest.getDificulty());
			
			if(levelOptional.isPresent()) {
				
			    levels.add(levelMapper.toDto(levelOptional.get()));
			
			}
		}
		
		return(levels);
	
	}	
	
	public LevelDTO findlevelwhithnumberGrade(Integer id, GradeType dificulty){		
		
		Optional<Level>  levelOptional =  levelRepository.findLevelBynumberAndGrade(id, dificulty);
		
		if(levelOptional.isPresent()) {
				
		  return levelMapper.toDto(levelOptional.get());
			
		}
		return null;
	
    }

	public List<Long> addLevelList(List<AddLevelRequest> levelParams){
		List<Long> addLevelIds = new ArrayList<>();
		
		for(AddLevelRequest addLevelRequest:levelParams) {
			
			LevelDTO level = new LevelDTO();
			level.setGrade(addLevelRequest.getDificulty());
			level.setNumber(addLevelRequest.getGrade());
			level.setDescription(null);
			
			LevelDTO addLevel = addLevel(level);
			
			addLevelIds.add(addLevel.getId());
			
		}
		return(addLevelIds);
	}

	
	public List<LevelDTO> addLevelData(List<LevelDTO> levels) {
		
		List<LevelDTO> addLevels = new ArrayList<>();
		
		for(LevelDTO level:levels) {

			LevelDTO addLevel =  addLevel(level);
			
			addLevels.add(addLevel);
		}
		
		return addLevels;
	}
	
	public List<LevelDTO> inputLevelData(MultipartFile file) {
		
		List<LevelDTO> addLevels = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		TypeReference<List<LevelDTO>> typeReference = new TypeReference<List<LevelDTO>>(){};
		
		InputStream inputStream = null;
		
		try {
			inputStream = file.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<LevelDTO> level = mapper.readValue(inputStream,typeReference);
			addLevels = addLevelData(level);
			return addLevels;
			
		} catch (IOException e){
			System.out.println("Unable to save level: " + e.getMessage());
		}
		
		return null;
	}

	public Page<LevelDTO> findPage(Pageable pageable) {
		
		Page<Level>  allLevels = levelRepository.findAll(pageable);
		
		log.info("Retrived levels {} ===> ", allLevels );;
		
		return allLevels.map(levelMapper::toDto);
	}
		

}