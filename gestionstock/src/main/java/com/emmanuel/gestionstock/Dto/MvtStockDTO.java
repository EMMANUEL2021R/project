package com.emmanuel.gestionstock.Dto;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;


@Data
public class MvtStockDTO {
	
	private  Long Id;
	
	private Instant datemvt;
	
	private BigDecimal quantite;
	
	
	private ArticleDTO articleDTO; 
//on cree un enumerateur pour les type de mvts de stock
	
	 private TypeMvtStockDTO typemvtDTO;
	

}
