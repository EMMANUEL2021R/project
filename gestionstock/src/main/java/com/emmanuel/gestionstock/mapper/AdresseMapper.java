package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.AdresseDTO;
import com.emmanuel.gestionstock.model.Adresse;

@Mapper(componentModel = "spring")
public interface AdresseMapper extends EntityMapper<AdresseDTO, Adresse> {

	@Override
	Adresse toEntity(AdresseDTO dto);

	@Override
	AdresseDTO toDto(Adresse entity);

	@Override
	List<Adresse> toEntity(List<AdresseDTO> dtoList);

	@Override
	List<AdresseDTO> toDto(List<Adresse> entityList);

}


