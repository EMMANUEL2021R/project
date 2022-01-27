package com.emmanuel.gestionstock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
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
@Table(name="entreprise")
public class Entreprise {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="nom")
	private String nom; 
	
	@Column(name="description")
	private String description; 
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="codefiscal")
	private String codefiscal; 
	
	@Column(name="email")
	private String email; 
	
	@Column(name="numtel")
	private String numtel; 
	
	@Column(name="siteweb")
	private String siteweb; 
	
	@Column(name="photo")
	private String photo; 
	
	@OneToMany(mappedBy="entreprise")
	private List <Utilisateur>  utilisateur;

}
