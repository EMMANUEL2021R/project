package com.emmanuel.gestionstock.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name="vente")
public class Vente {
	
	@Id
	@GeneratedValue
	private  Long id;
	
@Column(name="code")
private String code;

@Column(name="datevente")
private Instant datevente;

@Column(name="commentaire")
private String commentaire;


}
