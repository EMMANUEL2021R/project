package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.VenteDTO;
import com.emmanuel.gestionstock.model.Vente;

@Mapper(componentModel = "spring")
public interface VenteMapper extends EntityMapper<VenteDTO, Vente> {

	@Override
	Vente toEntity(VenteDTO dto);

	@Override
	VenteDTO toDto(Vente entity);

	@Override
	List<Vente> toEntity(List<VenteDTO> dtoList);

	@Override
	List<VenteDTO> toDto(List<Vente> entityList);

}


