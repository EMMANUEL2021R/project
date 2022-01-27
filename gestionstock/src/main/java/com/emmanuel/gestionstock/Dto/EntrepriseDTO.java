package com.emmanuel.gestionstock.Dto;


import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
public class EntrepriseDTO {
	
	
	private  Long Id;
	
	private String nom; 
	
	private String description; 
	
	private AdresseDTO adresseDTO;
	
	private String codefiscal; 
	
	private String email; 
	
	private String numtel; 
	
	private String siteweb; 
	
	private String photo; 
	
	private List <UtilisateurDTO>  utilisateurDTO;

}
