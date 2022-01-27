package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.EntrepriseDTO;
import com.emmanuel.gestionstock.model.Entreprise;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class,AdresseMapper.class})
public interface EntrepriseMapper extends EntityMapper<EntrepriseDTO, Entreprise> {

	@Override
	Entreprise toEntity(EntrepriseDTO dto);

	@Override
	EntrepriseDTO toDto(Entreprise entity);

	@Override
	List<Entreprise> toEntity(List<EntrepriseDTO> dtoList);

	@Override
	List<EntrepriseDTO> toDto(List<Entreprise> entityList);

}


