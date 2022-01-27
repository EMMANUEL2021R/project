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

import com.efunzo.services.epellation.domaine.EpellationUser;
import com.efunzo.services.epellation.model.request.EpellationUserRequest;
import com.efunzo.services.epellation.model.request.LoginRequest;
import com.efunzo.services.epellation.model.response.EpellationSessionResponse;
import com.efunzo.services.epellation.model.response.EpellationUserResponse;
import com.efunzo.services.epellation.model.response.LoginResponse;
import com.efunzo.services.epellation.service.EpellationUserService;
import com.efunzo.services.epellation.service.dto.EpellationUserDTO;

import javassist.NotFoundException;

@Controller
public class EpellationUserController {
	
	@Autowired
	EpellationUserService epellationUserService;

	 @GetMapping("/api/words/user/{user}/level/{level}/grade/{grade}")
	public ResponseEntity<EpellationSessionResponse> getWords(@PathVariable(name="level") Integer level, @PathVariable(name="grade") String grade, @PathVariable(name="user") Long user ){
		
		EpellationSessionResponse epellationSessionResponse = epellationUserService.getWords(level, grade, user);
		return ResponseEntity.status(HttpStatus.OK).body(epellationSessionResponse);
	}

	
	@PostMapping("/api/epellation/login")
	public ResponseEntity<LoginResponse> loadUser(@RequestBody LoginRequest loginRequest) throws NotFoundException{
		
		LoginResponse user = epellationUserService.loadUser(loginRequest);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
	@PostMapping("/api/epellation/user")
	public ResponseEntity<EpellationUserResponse> registerUser(@RequestBody EpellationUserRequest epellationUserRequest){
		
		EpellationUserResponse registerUser = epellationUserService.registerUser(epellationUserRequest);
		return ResponseEntity.status(HttpStatus.OK).body(registerUser);
	}
	

	@PutMapping("/api/epellation/user")
	public ResponseEntity<EpellationUserDTO> updatesepellationUsert(@RequestBody EpellationUserDTO epellationUser){
		
		EpellationUserDTO addedepellationUser = epellationUserService.updateEpellationUser(epellationUser);
		
		return ResponseEntity.status(HttpStatus.OK).body(addedepellationUser);
	}
	
	
	@GetMapping("/api/epellation/user/all")
	public ResponseEntity<List<EpellationUserDTO>> findAllepellationUser(){
		
		List<EpellationUserDTO> epellationUsers = epellationUserService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(epellationUsers);
	}
		
	@DeleteMapping("/api/epellation/user/{id}")
	public ResponseEntity<Void> deleteepellationUser(@PathVariable(name="id") Long id) {
		
		epellationUserService.deleteEpellationUser(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	 @GetMapping("/api/Epellation/user/name/{name}")
	 public ResponseEntity<EpellationUserDTO> findepellationUserByNameAndId(@PathVariable(name="name") String name){
		
		EpellationUserDTO epellationUser = epellationUserService.findEpellationUserByUserName(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(epellationUser);
	}
	 

	 @GetMapping("/api/epellation/user/{identifier}")
		public ResponseEntity<EpellationUserDTO> findepellationUserByName_Id(@PathVariable(name="identifier") String identifier){

			EpellationUserDTO epellationUser = epellationUserService.findEpellationUserByUserName_Id(identifier);
			
			return ResponseEntity.status(HttpStatus.OK).body(epellationUser);	
	 }
	 
	 
	 @PostMapping(value = "/api/csv/upload/file", consumes = {"multipart/form-data", "text/csv"})
	 public ResponseEntity<List<EpellationUserDTO>> upload(@RequestParam("file") MultipartFile file) throws IOException {

	 List<EpellationUserDTO> addCsvToEpellationUser = epellationUserService.csvToEpellationUserData(file);
	 
	 return ResponseEntity.status(HttpStatus.OK).body(addCsvToEpellationUser);		
	 }	
	 
	 
	 @PostMapping(value = "/api/epellation/user/file", consumes = {"multipart/form-data", "application/json"})
	 public ResponseEntity<List<EpellationUserResponse>> uploadJsonFileOfEpellationUser(@RequestParam("file") MultipartFile file) throws IOException {
		 
		 List<EpellationUserResponse> epellationUserResponses = epellationUserService.saveJsonEpellationUserData(file);
		 return ResponseEntity.status(HttpStatus.OK).body(epellationUserResponses);
	 }

}
