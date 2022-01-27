package com.emmanuel.gestionstock.model;

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
@Table(name="roles")
public class Roles  {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="roleName")
	private String roleName;
	
	@ManyToOne
	@JoinColumn(name="idutilisateur")
	private Utilisateur utilisateur;

}
