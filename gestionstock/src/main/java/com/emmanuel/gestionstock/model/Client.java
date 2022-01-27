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
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Embedded  // pour dire que c'est un champ composé
	private Adresse adresse;
	
	@Column(name="email")
	private String email;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="numtel")
	private String numtel;
	
	
	@OneToMany(mappedBy="Idclient") // un client peut avoir plusieur commande client dans la base de données
	private List <CommandeClient> commandeclients;
	


}
