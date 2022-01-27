package com.efunzo.services.epellationfront.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efunzo.services.epellationfront.client.epellation.client.EpellationClient;
import com.efunzo.services.epellationfront.client.epellation.client.model.Level;

@Service
public class ApelationService {
	
	@Autowired
	private EpellationClient epellationClient;
	
	
	public List<Level> getAllLevel(){
		
		return epellationClient.getAllLevels();
	}

}
