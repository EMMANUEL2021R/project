package com.emmanuel.gestionstock.Dto;


import lombok.Data;

@Data
public class RolesDTO {
	
	private  Long Id;
	
    private String roleName;
	
	private UtilisateurDTO utilisateurDTO;

}
