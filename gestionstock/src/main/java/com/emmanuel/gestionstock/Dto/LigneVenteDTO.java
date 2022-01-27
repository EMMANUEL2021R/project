package com.emmanuel.gestionstock.Dto;

import java.math.BigDecimal;


import lombok.Data;


@Data
public class LigneVenteDTO {
	
	private  Long Id;
	
	private VenteDTO venteDTO;
	
	private BigDecimal quantite;

	private BigDecimal prixunitaire;

}
