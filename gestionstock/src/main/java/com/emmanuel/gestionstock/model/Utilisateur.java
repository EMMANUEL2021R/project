package com.emmanuel.gestionstock.model;


import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="nom")
	private String nom; 
	
	@Column(name="prenom")
	private String prenom; 
	
	@Column(name="datenaissance")
	private Instant datenaissance;
	
	@Column(name="email")
	private String email; 
	
	@Column(name="motdepass")
	private String motdepass; 
	
	@Embedded 
	private Adresse adresse;
	
	@Column(name="photo")
	private String photo; 
	
	
	
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy="utilisateur")
	private List <Roles>  roles;
	

}
