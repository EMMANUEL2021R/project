package com.efunzo.services.epellation.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.efunzo.services.epellation.domaine.EpellationUser;
import com.efunzo.services.epellation.domaine.GradeType;
import com.efunzo.services.epellation.domaine.Role;
import com.efunzo.services.epellation.domaine.SpellingSession;
import com.efunzo.services.epellation.domaine.SpellingSessionItem;
import com.efunzo.services.epellation.domaine.SpellingWord;
import com.efunzo.services.epellation.model.request.EpellationUserRequest;
import com.efunzo.services.epellation.model.request.LoginRequest;
import com.efunzo.services.epellation.model.response.EpellationSessionResponse;
import com.efunzo.services.epellation.model.response.EpellationUserResponse;
import com.efunzo.services.epellation.model.response.LoginResponse;
import com.efunzo.services.epellation.repository.EpellationUserRepository;
import com.efunzo.services.epellation.service.dto.EpellationUserDTO;
import com.efunzo.services.epellation.service.dto.SpellingSessionDTO;
import com.efunzo.services.epellation.service.dto.SpellingSessionItemDTO;
import com.efunzo.services.epellation.service.dto.SpellingWordDTO;
import com.efunzo.services.epellation.service.mapper.EpellationUserMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;

@Service
public class EpellationUserService {
	
	private final Logger log = LoggerFactory.getLogger(EpellationUserService.class);

	@Value("${epellation.word.per.session}")
	private int numberOfWord;
	
	@Autowired
	private SpellingWordService spellingWordService;
	
	@Autowired
	private EpellationUserRepository epellationUserRepository;
	
	@Autowired
	private SpellingSessionItemService spellingSessionItemService;
	
	@Autowired
	private SpellingSessionService spellingSessionService;
	
	@Autowired
	private EpellationUserMapper epellationUserMapper;
	 

	 public LoginResponse loadUser(LoginRequest loginRequest) throws NotFoundException {
		 
		Optional<EpellationUser> user = epellationUserRepository.findEpellationUserByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
		LoginResponse loginResponse = new LoginResponse();
		
		EpellationUser loadUser;
		if(user.isPresent()) {
			loadUser =  user.get();
			loginResponse.setFirstName(loadUser.getFirstName());
			loginResponse.setLastName(loadUser.getLastName());
			loginResponse.setUserName(loadUser.getUserName());
			loginResponse.setSchoolLevel(loadUser.getSchoolLevel());
			loginResponse.setPhoneNumber(loadUser.getPhoneNumber());
			loginResponse.setEmail(loadUser.getEmail());
			loginResponse.setRole(loadUser.getRole());
			
			return loginResponse;
		}else {
			throw new NotFoundException("User not found any authentication of your details");
		}
	 }
	 
	
	public EpellationUserResponse registerUser(EpellationUserRequest epellationUserRequest) {
		
		EpellationUser epellationUser = new EpellationUser();
		
		epellationUser.setLastName(epellationUserRequest.getLastName());
		epellationUser.setFirstName(epellationUserRequest.getFirstName());
		epellationUser.setUserName(epellationUserRequest.getUserName());
		epellationUser.setEmail(epellationUserRequest.getEmail());
		epellationUser.setPassword(epellationUserRequest.getPassword());
		epellationUser.setPhoneNumber(epellationUserRequest.getPhoneNumber());
		epellationUser.setRole(epellationUserRequest.getRole());
		epellationUser.setSchoolLevel(epellationUserRequest.getSchoolLevel());

		EpellationUser savedEpellationUser	= epellationUserRepository.save(epellationUser) ;

		log.info("Registration User {} ---> ",epellationUser);
		
		EpellationUserResponse epellationUserResponse = new EpellationUserResponse();
		
		epellationUserResponse.setFirstName(savedEpellationUser.getFirstName());
		epellationUserResponse.setLastName(savedEpellationUser.getLastName());
		epellationUserResponse.setId(savedEpellationUser.getId());
		epellationUserResponse.setUserName(savedEpellationUser.getUserName());
		epellationUserResponse.setPhoneNumber(savedEpellationUser.getPhoneNumber());
		epellationUserResponse.setRole(savedEpellationUser.getRole());
		epellationUserResponse.setEmail(savedEpellationUser.getEmail());
		epellationUserResponse.setPassword(savedEpellationUser.getPassword());
		
	    if(Role.STUDENT.equals(savedEpellationUser.getRole())) {
	    	epellationUserResponse.setSchoolLevel(savedEpellationUser.getSchoolLevel());
		}
	    epellationUserResponse.setSchoolLevel(savedEpellationUser.getSchoolLevel());
		return epellationUserResponse;
	}
	

	public void deleteEpellationUser(Long id) {

		epellationUserRepository.deleteById(id);
	
	log.info("Dellete epellationUser by Id {} ===> ", id );
	
	}
	

	public EpellationUserDTO updateEpellationUser(EpellationUserDTO epellationUser) {

		if(epellationUser.getId() !=null) {
		
			EpellationUser savedEpellationUser= epellationUserRepository.save(epellationUserMapper.toEntity(epellationUser));

			log.info("Saved savedepellationUser{} ===> ", savedEpellationUser );
			
			EpellationUserDTO savedEpellationUserDTO = epellationUserMapper.toDto(savedEpellationUser);
			return savedEpellationUserDTO;
	    }
		return null;
	}
	

	public List<EpellationUserDTO> findAll() {
		
			List<EpellationUser>  allEpellationUsers = epellationUserRepository.findAll();
			
			log.info("Retrived EpellationUsers {} ===> ", allEpellationUsers );
			return epellationUserMapper.toDto(allEpellationUsers);
	}


    public EpellationUserDTO findEpellationUserByUserName(String name) {
		
		    Optional<EpellationUser> epellationUserOptional = epellationUserRepository.findEpellationUserByUserName(name);
		 
		    if(epellationUserOptional.isPresent()) {
		    	
		    	 log.info("Retrived epellationUser {} ===> ", epellationUserOptional.get() );
		    	 
		    	 EpellationUser epellationUser = epellationUserOptional.get();
		    	 
			    return epellationUserMapper.toDto(epellationUser);
		}
		return null;
     }

		public EpellationUserDTO findEpellationUserByUserId(Long id) {

			Optional<EpellationUser> epellationUserOptional = epellationUserRepository.findEpellationUserById(id);

			if (epellationUserOptional.isPresent()) {
				
				log.info("Retrived epellationUser {} ===> ", epellationUserOptional.get());

				EpellationUser epellationUser = epellationUserOptional.get();

				return epellationUserMapper.toDto(epellationUser);
			}
			return null;
		}
     	
		public EpellationUserDTO findEpellationUserByUserName_Id(String identifier) {

			EpellationUserDTO epellationUser= null;


			if (NumberUtils.isDigits(identifier)) {

				epellationUser = findEpellationUserByUserId(Long.parseLong(identifier));

				log.info("Retrived EpellationUser {} ===> ", epellationUser);

				return epellationUser;

			} else {

				epellationUser = findEpellationUserByUserName(identifier);
				
				log.info("Retrived EpellationUser {} ===> ", epellationUser);
				
				return epellationUser;
			
			}
		}

    
	public EpellationSessionResponse getWords(Integer level, String grad, Long epellationUser) {
		
		EpellationSessionResponse epellationSessionResponse = new EpellationSessionResponse();
		
		List<SpellingWordDTO> words =  new ArrayList<>();
		
		if(grad.equals("MIXT")) {
			
			words = spellingWordService.findSpellingWordByLevels_Number(level);	
			
			Collections.shuffle(words);
			
			List<SpellingWordDTO> choosenWords = words.stream()
					.limit(numberOfWord)
					.collect(Collectors.toList());
			
			epellationSessionResponse.setSpellingWords(choosenWords);	
			
			return epellationSessionResponse;
		}
		
		
		words = spellingWordService.findSpellingWordByLevelNumber(level, GradeType.valueOf(grad));	
		
		
		Collections.shuffle(words);
		
		List<SpellingWordDTO> choosenWords = words.stream()
		   .limit(numberOfWord)
		   .collect(Collectors.toList());
		
		
		epellationSessionResponse.setSpellingWords(choosenWords);
		
		createSpellingSession(epellationUser, choosenWords);
		
		return epellationSessionResponse;
	}
	
	
    public void createSpellingSession (Long userId, List<SpellingWordDTO> spellingWords) {
    	
    	EpellationUserDTO epellationUser = findEpellationUserByUserId(userId);
    	
		
		SpellingSessionDTO savedSpellingSession = spellingSessionService.addSpellingSession(new SpellingSessionDTO(epellationUser, Instant.now()));
		
		for(SpellingWordDTO word:spellingWords) {
			
			SpellingSessionItemDTO savedSpellingSessionItem = new SpellingSessionItemDTO(word, Instant.now(), Instant.now()); 
			
			savedSpellingSessionItem.setSpellingSession(savedSpellingSession);
			
			spellingSessionItemService.addSpellingSessionItem(savedSpellingSessionItem);
		}
	}

	
	
	public List<EpellationUserResponse> saveEpellationUserData(List<EpellationUserRequest> epellationUserRequests) {

		List<EpellationUserResponse> epellationUserResponses = new ArrayList<>();

		for(EpellationUserRequest epellationUserRequest:epellationUserRequests) {
			
			EpellationUserResponse epellationUserResponse  = registerUser(epellationUserRequest);
			
			epellationUserResponses.add(epellationUserResponse);
		}
		return epellationUserResponses;
	}
	
	
	public List<EpellationUserResponse> saveJsonEpellationUserData(MultipartFile fileInput) throws IOException  {
		
		List<EpellationUserResponse> epellationUserResponses = new ArrayList<>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<EpellationUserRequest> epellationUserRequests = objectMapper.readValue(fileInput.getInputStream(), new TypeReference<List<EpellationUserRequest>>(){});
		
		epellationUserResponses = saveEpellationUserData(epellationUserRequests);
		return epellationUserResponses;
	}
	
	
	public List<EpellationUserDTO> csvToEpellationUser(List<EpellationUserRequest> epellationUserRequests) {

		List<EpellationUserDTO> lisUsers = new ArrayList<>();

		for(EpellationUserRequest epellationUserRequest:epellationUserRequests) {
			
			EpellationUserDTO user = new EpellationUserDTO();
			user.setId(epellationUserRequest.getId());
			user.setFirstName(epellationUserRequest.getFirstName());
			user.setLastName(epellationUserRequest.getLastName());
			user.setUserName(epellationUserRequest.getUserName());
			user.setPassword(epellationUserRequest.getPassword());
			user.setEmail(epellationUserRequest.getEmail());
			user.setPhoneNumber(epellationUserRequest.getPhoneNumber());
			user.setRole(epellationUserRequest.getRole());
			user.setSchoolLevel(epellationUserRequest.getSchoolLevel());
			lisUsers.add(user);
		}
		return lisUsers;
	}
	
	public List<EpellationUserDTO> csvToEpellationUserData(MultipartFile fileInput) throws IOException {

		List<EpellationUser> epellationUsers = new ArrayList<>();

		List<EpellationUserRequest> epellationUserRequests = new ArrayList<>();

		CsvMapper mapper = new CsvMapper();

		CsvSchema schema = mapper.schemaFor(EpellationUserRequest.class).withHeader().withColumnReordering(true);

		ObjectReader reader = mapper.readerFor(EpellationUserRequest.class).with(schema);

		epellationUserRequests = reader.<EpellationUserRequest>readValues(fileInput.getInputStream()).readAll();

		epellationUsers = epellationUserRepository.saveAll(epellationUserMapper.toEntity(csvToEpellationUser(epellationUserRequests)));
		
		log.info("Saved epellationUsers {} ---> ", epellationUsers);
		
		return epellationUserMapper.toDto(epellationUsers);
	}

	
	
}


	