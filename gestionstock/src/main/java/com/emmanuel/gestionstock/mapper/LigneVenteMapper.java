package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.LigneVenteDTO;
import com.emmanuel.gestionstock.model.LigneVente;

@Mapper(componentModel = "spring", uses = {VenteMapper.class})
public interface LigneVenteMapper extends EntityMapper<LigneVenteDTO, LigneVente> {

	@Override
	LigneVente toEntity(LigneVenteDTO dto);

	@Override
	LigneVenteDTO toDto(LigneVente entity);

	@Override
	List<LigneVente> toEntity(List<LigneVenteDTO> dtoList);

	@Override
	List<LigneVenteDTO> toDto(List<LigneVente> entityList);

}


