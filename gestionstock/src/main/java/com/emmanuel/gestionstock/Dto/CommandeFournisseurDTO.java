package com.emmanuel.gestionstock.Dto;

import java.time.Instant;
import java.util.List;

import lombok.Data;

@Data
public class CommandeFournisseurDTO {
	
	private  Long Id;
	
	private String ref;
	
	private Instant datecommande;
	
	private FournisseurDTO fournisseurDTO ;
	
	private List <LigneCommandeFournisseurDTO> lignecommandefournisseurDTO;
	

}
