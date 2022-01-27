package com.efunzo.services.epellationfront.client.epellation.histrix;

import java.util.ArrayList;
import java.util.List;

import com.efunzo.services.epellationfront.client.epellation.client.EpellationClient;
import com.efunzo.services.epellationfront.client.epellation.client.model.Level;

public class EpellationFaillback implements EpellationClient{

	@Override
	public List<Level> getAllLevels() {
		
		return new ArrayList<>();
	}

}
