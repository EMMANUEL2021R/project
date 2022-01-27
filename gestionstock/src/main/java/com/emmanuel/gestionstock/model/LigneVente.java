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
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="lignevente")
public class LigneVente {
	
	
	@Id
	@GeneratedValue
	private  Long Id;
	
	@ManyToOne
	@JoinColumn(name="idvente")
	private Vente vente;
	
	@Column(name="quantite")
	private BigDecimal quantite;

	@Column(name="prixunitaire")
	private BigDecimal prixunitaire;
}
