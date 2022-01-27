package com.emmanuel.gestionstock.model;


import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="commandefournisseur")
public class CommandeFournisseur  {
	
	@Id
	@GeneratedValue
	private  Long Id;
	
	@Column(name="ref")
	private String ref;
	
	@Column(name="datecommande")
	private Instant datecommande;
	
	@ManyToOne  //plusieurs cmd fournisseurs peuvent appartenir a un fournisseur 
	@JoinColumn(name="idfournisseur")
	private Fournisseur fournisseur ;
	
	@OneToMany(mappedBy="commandefournisseur")
	private List <LigneCommandeFournisseur> ligneCommandeFournisseur;
	

}
