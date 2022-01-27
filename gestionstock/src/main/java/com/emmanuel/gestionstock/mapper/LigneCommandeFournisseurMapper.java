package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.LigneCommandeFournisseurDTO;
import com.emmanuel.gestionstock.model.LigneCommandeFournisseur;

@Mapper(componentModel = "spring", uses = {ArticleMapper.class})
public interface LigneCommandeFournisseurMapper extends EntityMapper<LigneCommandeFournisseurDTO, LigneCommandeFournisseur> {

	@Override
	LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDTO dto);

	@Override
	LigneCommandeFournisseurDTO toDto(LigneCommandeFournisseur entity);

	@Override
	List<LigneCommandeFournisseur> toEntity(List<LigneCommandeFournisseurDTO> dtoList);

	@Override
	List<LigneCommandeFournisseurDTO> toDto(List<LigneCommandeFournisseur> entityList);

}



