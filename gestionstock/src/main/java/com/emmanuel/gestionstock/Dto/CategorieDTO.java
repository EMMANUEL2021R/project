package com.emmanuel.gestionstock.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CategorieDTO {
	
	private  Long Id;
	
	private String code;
	
	private String designation;
	
	@JsonIgnore // je veux obtenir dans le mapping que les categories
	private List <ArticleDTO> articlesDTO;
	
}
