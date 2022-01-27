package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.FournisseurDTO;
import com.emmanuel.gestionstock.model.Fournisseur;

@Mapper(componentModel = "spring", uses = {CommandeFournisseurMapper.class,AdresseMapper.class})
public interface FournisseurMapper extends EntityMapper<FournisseurDTO, Fournisseur> {

	@Override
	Fournisseur toEntity(FournisseurDTO dto);

	@Override
	FournisseurDTO toDto(Fournisseur entity);

	@Override
	List<Fournisseur> toEntity(List<FournisseurDTO> dtoList);

	@Override
	List<FournisseurDTO> toDto(List<Fournisseur> entityList);

}


