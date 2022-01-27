package com.emmanuel.gestionstock.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(name="article")
public class Article  {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="codearticle")
	private String codearticle;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="prixunitaireht")
	private BigDecimal  prixunitaireht;
	
	@Column(name="tauxtva")
	private BigDecimal  tauxtva;
	
	@Column(name="prixunitairettc")
	private BigDecimal  prixunitairettc;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="idcategorie")
	private Categorie categorie;
	

}
