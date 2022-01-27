package com.emmanuel.gestionstock.Dto;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class ArticleDTO {

	private  Long Id;
	
	private String codearticle;
	
	private String designation;
	
	private BigDecimal  prixunitaireht;
	
	private BigDecimal  tauxtva;
	
	private BigDecimal  prixunitairettc;
	
	private String photo;
	
	private CategorieDTO categorieDTO;
	

}

	
	
	
