package com.efunzo.services.epellation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.efunzo.services.epellation.domaine.Level;
import com.efunzo.services.epellation.service.LevelService;
import com.efunzo.services.epellation.service.dto.LevelDTO;
import com.efunzo.services.epellation.service.dto.SpellingWordDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api("epellation/v1" + "/Level")
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	@PostMapping("/api/level")
	@ApiOperation(value = "cette methode permet d'Enregistrer un SpellingWord",notes = "Enregistrer ou modifier un Level",response = LevelDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="L'objet Level a ete cree/modifie"),
			@ApiResponse(code = 400, message="L'objet Level n'est pas valide")
	})
	public ResponseEntity<LevelDTO> addLevel(@RequestBody LevelDTO level){
		
		LevelDTO addedLevel = levelService.addLevel(level);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedLevel);
	}
	
	
	@PostMapping("/api/level/list")
	public ResponseEntity<List<LevelDTO>> addManyLevels(@RequestBody List<LevelDTO> levels){
		
		List<LevelDTO> addedLevels = levelService.addManyLevel(levels);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedLevels);
	}
	
	
	@GetMapping("/api/level/{id}")
	public ResponseEntity<LevelDTO> findLevelById(@PathVariable(name="id") Long id){
		
		LevelDTO level = levelService.findLevelById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(level);
	}
	
	@GetMapping("/api/level/all")
	public ResponseEntity<List<LevelDTO>> findAllLevel(){
		
		List<LevelDTO> levels = levelService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(levels);
	}
	
	@GetMapping("/api/level/page")
	public ResponseEntity<Page<LevelDTO>> findAllLevel(Pageable pageable){
		
		Page<LevelDTO> levels = levelService.findPage(pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(levels);
	}
	
	
}
