package com.efunzo.services.epellation.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.efunzo.services.epellation.model.request.AddWordRequest;
import com.efunzo.services.epellation.model.response.AddWordResponse;
import com.efunzo.services.epellation.service.SpellingWordService;
import com.efunzo.services.epellation.service.dto.SpellingWordDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api("epellation/v1" + "/SpellingWord")
public class SpellingWordController {
	
	@Autowired
	private SpellingWordService spellingWordService;

	
	@PostMapping("/api/spelling-word")
	@ApiOperation(value = "Enregistrer un SpellingWord",notes = "cette methode permet d'Enregistrer ou modifier un SpellingWord",response = SpellingWordDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="L'objet SpellingWord a ete cree/modifie"),
			@ApiResponse(code = 400, message="L'objet SpellingWord n'est pas valide")
	})
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
	@ApiOperation(value = "Ajouter une liste de SpellingWord",notes = "cette methode permet d'Enregistrerune liste de SpellingWord",response = SpellingWordDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="La liste de  SpellingWord ajoutee"),
	})
	public ResponseEntity<List<SpellingWordDTO>> addManySpellingWords(@RequestBody List<SpellingWordDTO> spellingWords){
		
		List<SpellingWordDTO> addedSpellingWords = spellingWordService.addManySpellingWord(spellingWords);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedSpellingWords);
	}
	
	
	@GetMapping("/api/spelling-word/{id}")
	@ApiOperation(value = "Rechercher un SpellingWord",notes = "cette methode permet de Rechercher un SpellingWord par son ID",response = SpellingWordDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="L'objet SpellingWord a ete trouve dans la base de donnees"),
			@ApiResponse(code = 404, message="aucun SpellingWord dans la base de donnees avec le ID donnee.")
	})
	public ResponseEntity<SpellingWordDTO> findSpellingWordById(@PathVariable(name="id") Long id){
		
		SpellingWordDTO spellingWord = spellingWordService.findSpellingWordById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(spellingWord);
	}
	
	@GetMapping("/api/spelling-word/all")
	@ApiOperation(value = "Renvoie la liste des SpellingWord",notes = "cette methode permet de Rechercher et renvoyer la liste des SpellingWord qui existe dans la base de donnees",responseContainer ="List<SpellingWordDTO>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="la liste des SpellingWord/une liste vide")
	})
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
	@ApiOperation(value = "supprimer un SpellingWord",notes = "cette methode permet de supprimer un SpellingWord par son ID",response = SpellingWordDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="L'objet SpellingWord a ete supprime dans la base de donnees")
	})
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
	 
	 @GetMapping("/api/spelling-word/page")
		@ApiOperation(value = "Renvoie la liste des SpellingWord",notes = "cette methode permet de Rechercher et renvoyer une page des SpellingWord qui existe dans la base de donnees",responseContainer ="List<SpellingWordDTO>")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message="la liste des SpellingWord/une liste vide")
		})
		public ResponseEntity<Page<SpellingWordDTO>> findAllSpellingWord(Pageable pageable){
			
			Page<SpellingWordDTO> spellingWords = spellingWordService.findAll(pageable);
			
			return ResponseEntity.status(HttpStatus.OK).body(spellingWords);
		}


}
