package com.emmanuel.gestionstock.Dto;


import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
public class FournisseurDTO {

	
	private  Long Id;
	
	private String nom;

	private String prenom;
	
	private AdresseDTO adresseDTO;
	
	private String email;
	
	private String photo;
	
	private String numtel;
	
	private List <CommandeFournisseurDTO> commandefournisseurDTO;
	
	
}
