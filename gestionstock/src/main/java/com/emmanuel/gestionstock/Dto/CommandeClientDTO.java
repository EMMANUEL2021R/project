package com.emmanuel.gestionstock.Dto;


import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
public class CommandeClientDTO {
	
	private  Long Id;
	
	private String ref;
	

	private Instant datecommande;
	
	
	private ClientDTO client ;
	
	
	private List <LigneCommandeClientDTO> lignecommandeclient;
	

}
