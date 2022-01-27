package com.emmanuel.gestionstock.model;


import java.math.BigDecimal;
import java.time.Instant;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="mvtsock")
public class MvtStock {
	
	@Id
	@GeneratedValue
	private  Long id;
	
	@Column(name="datemvt")
	private Instant datemvt;
	

	@Column(name="quantite")
	private BigDecimal quantite;
	
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article; 
//on cree un enumerateur pour les type de mvts de stock
	
	
	@Column(name="typemvt")
	 private TypeMvtstock typemvt;
	
	
}
