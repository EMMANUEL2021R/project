package com.emmanuel.gestionstock.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Embeddable //pour
@Table(name="adresse")
public class Adresse  {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="adresse1")
	private String adresse1;
	
	@Column(name="adresse2")
	private String adresse2;
	
	@Column(name="ville")
	private String vile;
	
	@Column(name="codepostale")
	private String codepostale;
	
	@Column(name="pays")
	private String pays;


}
