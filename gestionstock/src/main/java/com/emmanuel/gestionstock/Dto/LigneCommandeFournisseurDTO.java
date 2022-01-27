package com.emmanuel.gestionstock.Dto;


import java.math.BigDecimal;



import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeFournisseurDTO {
	
	private  Long Id;
	
	private ArticleDTO articleDTO;

	private BigDecimal quantite;

	private BigDecimal prixunitaire;

}
