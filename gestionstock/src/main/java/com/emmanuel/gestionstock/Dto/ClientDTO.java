package com.emmanuel.gestionstock.Dto;

import java.util.List;

import com.emmanuel.gestionstock.model.Adresse;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
public class ClientDTO {
	
	private  Long Id;
	
	private String nom;
	
	
	private String prenom;
	
	
	private Adresse adresse;
	
	
	private String email;
	
	
	private String photo;
	
	
	private String numtel;
	
	@JsonIgnore
	private List <CommandeClientDTO> commandeclients;

}