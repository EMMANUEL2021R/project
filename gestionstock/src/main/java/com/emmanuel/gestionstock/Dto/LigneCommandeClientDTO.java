package com.emmanuel.gestionstock.Dto;


import java.math.BigDecimal;


import lombok.Builder;
import lombok.Data;


@Data
public class LigneCommandeClientDTO {
	
	private  Long Id;
	
	private ArticleDTO articleDTO;

	private CommandeClientDTO commandeclientDTO;

	private BigDecimal quantite;

	private BigDecimal prixunitaire;

}
