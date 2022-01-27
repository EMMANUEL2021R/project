package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.TypeMvtStockDTO;
import com.emmanuel.gestionstock.model.TypeMvtstock;

@Mapper(componentModel = "spring")
public interface TypeMvtStockMapper extends EntityMapper<TypeMvtStockDTO, TypeMvtstock> {

	@Override
	TypeMvtstock toEntity(TypeMvtStockDTO dto);

	@Override
	TypeMvtStockDTO toDto(TypeMvtstock entity);

	@Override
	List<TypeMvtstock> toEntity(List<TypeMvtStockDTO> dtoList);

	@Override
	List<TypeMvtStockDTO> toDto(List<TypeMvtstock> entityList);

}


