package com.efunzo.services.epellation.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.efunzo.services.epellation.domaine.SpellingWord;
import com.efunzo.services.epellation.model.request.AddWordRequest;
import com.efunzo.services.epellation.model.response.AddWordResponse;
import com.efunzo.services.epellation.service.SpellingWordService;
import com.efunzo.services.epellation.service.dto.SpellingWordDTO;
import com.efunzo.services.epellation.service.mapper.SpellingWordMapper;

@Controller
public class SpellingWordController {
	
	@Autowired
	private SpellingWordService spellingWordService;

	
	@PostMapping("/api/spelling-word")
	public ResponseEntity<SpellingWordDTO> addSpellingWord(@RequestBody SpellingWordDTO spellingWord){
		
		SpellingWordDTO addedSpellingWord = spellingWordService.addSpellingWord(spellingWord);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedSpellingWord);
	}
	
	@PostMapping("/api/spelling-word/light")
	public ResponseEntity<AddWordResponse> addSpellingWord(@RequestBody AddWordRequest addWordRequest){
		
		AddWordResponse addedSpellingWord = spellingWordService.addSpellingWord(addWordRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedSpellingWord);
	}
	
	@PostMapping("/api/spelling-word/light_list")
	public ResponseEntity<List<AddWordResponse>> addSpellingWordList(@RequestBody List<AddWordRequest> addWordRequests){
		
		List<AddWordResponse> addedSpellingWords = spellingWordService.addSpellingWordList(addWordRequests);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedSpellingWords);
	}
	
	
	@PostMapping("/api/spelling-word/list")
	public ResponseEntity<List<SpellingWordDTO>> addManySpellingWords(@RequestBody List<SpellingWordDTO> spellingWords){
		
		List<SpellingWordDTO> addedSpellingWords = spellingWordService.addManySpellingWord(spellingWords);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedSpellingWords);
	}
	
	
	@GetMapping("/api/spelling-word/{id}")
	public ResponseEntity<SpellingWordDTO> findSpellingWordById(@PathVariable(name="id") Long id){
		
		SpellingWordDTO spellingWord = spellingWordService.findSpellingWordById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(spellingWord);
	}
	
	@GetMapping("/api/spelling-word/all")
	public ResponseEntity<List<SpellingWordDTO>> findAllSpellingWord(){
		
		List<SpellingWordDTO> spellingWords = spellingWordService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(spellingWords);
	}
	
	@PutMapping("/api/spelling-word")
	public ResponseEntity<SpellingWordDTO> updateSpellingWord(@RequestBody SpellingWordDTO spellingWord){
		
		SpellingWordDTO addedSpellingWord = spellingWordService.updateSpellingWord(spellingWord);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedSpellingWord);
	}
	
	@DeleteMapping("/api/spelling-word/{id}")
	public ResponseEntity<Void> deleteSpellingWord(@PathVariable(name="id") Long id) {
		
		spellingWordService.deleteSpellingWord(id);
		return ResponseEntity.noContent().build();
	}

		 @PostMapping(value = "/api/upload/file/csv", consumes = {"multipart/form-data", "test/csv"})
	 public ResponseEntity<List<SpellingWordDTO>> uploadCSVFile(@RequestParam("file") MultipartFile file) throws IOException {

	 List<SpellingWordDTO> addWords = spellingWordService.inputSpellingWordDataCSV(file);
	 return ResponseEntity.status(HttpStatus.OK).body(addWords);
	 }

	 @PostMapping(value = "/api/spelling-word/addSpellingWordData", consumes = {"multipart/form-data", "application/json"})
	 public ResponseEntity<List<SpellingWordDTO>> uploadJsonFile(@RequestParam("file") MultipartFile file) {
		 
	 List<SpellingWordDTO> addWords = spellingWordService.inputSpellingWordDataJson(file);
	 return ResponseEntity.status(HttpStatus.OK).body(addWords);
	 }


}
