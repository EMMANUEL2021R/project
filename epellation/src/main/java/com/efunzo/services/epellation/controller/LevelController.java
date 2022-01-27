package com.efunzo.services.epellation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	/*
	@PostMapping("/api/level")
	public ResponseEntity<LevelDTO> addLevel(@RequestBody LevelDTO level){
		
		LevelDTO addedLevel = levelService.addLevel(level);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedLevel);
	}
	
	
	@PostMapping("/api/level/list")
	public ResponseEntity<List<LevelDTO>> addManyLevels(@RequestBody List<LevelDTO> levels){
		
		List<LevelDTO> addedLevels = levelService.addManyLevel(levels);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedLevels);
	}
	*/
	
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
	
	/*
	@PutMapping("/api/level")
	public ResponseEntity<LevelDTO> updateLevel(@RequestBody Level level){
		
		LevelDTO addedLevel = levelService.updateLevel(level);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedLevel);
	}
	
	@DeleteMapping("/api/level/{id}")
	public  ResponseEntity<LevelDTO> deleteLevel(@PathVariable(name="id") Long id) {
		
		levelService.deleteLevel(id);
		
		return ResponseEntity.noContent().build();
	}
   
	
	@PostMapping(value = "/api/level/addlevelData", consumes = {"multipart/form-data", "application/json"})
	 public ResponseEntity<List<LevelDTO>> upload(@RequestParam("file") MultipartFile file) {
		 
		List<LevelDTO> addLevels = levelService.inputLevelData(file);
	 return ResponseEntity.status(HttpStatus.OK).body(addLevels);
	 }
	  */

	
	

	
}
