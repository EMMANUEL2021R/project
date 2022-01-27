package com.emmanuel.gestionstock.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity

@Table(name="lignecommandeclient")

public class LigneCommandeClient  {
	
	@Id
	@GeneratedValue
	private  Long id;
	
@ManyToOne
@JoinColumn(name="idarticle")
private Article article;

@Column(name="idcommandeclient")
private CommandeClient commandeclient;

@Column(name="quantite")
private BigDecimal quantite;

@Column(name="prixunitaire")
private BigDecimal prixunitaire;


}
