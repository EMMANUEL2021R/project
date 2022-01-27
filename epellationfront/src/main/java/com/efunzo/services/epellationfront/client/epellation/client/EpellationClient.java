package com.efunzo.services.epellationfront.client.epellation.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.efunzo.services.epellationfront.client.epellation.client.model.Level;
import com.efunzo.services.epellationfront.client.epellation.histrix.EpellationFaillback;

@FeignClient(
		value = "epellationClient",
		url = "${epellation.Url}",
		fallback = EpellationFaillback.class)
public interface EpellationClient {

	
	@GetMapping(
			path= "/api/level/all",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	List<Level> getAllLevels();
	
	
}
