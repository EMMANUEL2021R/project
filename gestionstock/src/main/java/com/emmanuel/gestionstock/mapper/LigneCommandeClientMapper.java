package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.LigneCommandeClientDTO;
import com.emmanuel.gestionstock.model.LigneCommandeClient;

@Mapper(componentModel = "spring", uses = {CommandeClientMapper.class, ArticleMapper.class})
public interface LigneCommandeClientMapper extends EntityMapper<LigneCommandeClientDTO, LigneCommandeClient> {

	@Override
	LigneCommandeClient toEntity(LigneCommandeClientDTO dto);

	@Override
	LigneCommandeClientDTO toDto(LigneCommandeClient entity);

	@Override
	List<LigneCommandeClient> toEntity(List<LigneCommandeClientDTO> dtoList);

	@Override
	List<LigneCommandeClientDTO> toDto(List<LigneCommandeClient> entityList);

}


