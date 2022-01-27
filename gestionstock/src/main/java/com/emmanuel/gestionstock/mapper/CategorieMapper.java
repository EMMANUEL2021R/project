package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.CategorieDTO;
import com.emmanuel.gestionstock.model.Categorie;

@Mapper(componentModel = "spring", uses = {ArticleMapper.class})
public interface CategorieMapper extends EntityMapper<CategorieDTO, Categorie> {

	@Override
	Categorie toEntity(CategorieDTO dto);

	@Override
	CategorieDTO toDto(Categorie entity);

	@Override
	List<Categorie> toEntity(List<CategorieDTO> dtoList);

	@Override
	List<CategorieDTO> toDto(List<Categorie> entityList);

}


