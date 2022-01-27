package com.emmanuel.gestionstock.Dto;

import java.time.Instant;



import lombok.Builder;
import lombok.Data;


@Data
public class VenteDTO {
	
	private  Long Id;
	
	private String code;

	private Instant datevente;
	
	private String commentaire;

}
