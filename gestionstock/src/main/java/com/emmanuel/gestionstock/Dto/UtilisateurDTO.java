package com.emmanuel.gestionstock.Dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDTO {

	
	private  int id;
	
	private String nom; 
	
	private String prenom; 
	
	private Instant datenaissance;
	
	private String email; 
	
	private String motdepass; 
	
	private AdresseDTO adresseDTO;
	
	private String photo; 

	private EntrepriseDTO entrepriseDTO;
	
	private List <RolesDTO>  rolesDTO;
	
	
}
