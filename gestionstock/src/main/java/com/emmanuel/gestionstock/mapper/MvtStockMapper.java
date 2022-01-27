package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.MvtStockDTO;
import com.emmanuel.gestionstock.model.MvtStock;

@Mapper(componentModel = "spring", uses = {TypeMvtStockMapper.class,ArticleMapper.class})
public interface MvtStockMapper extends EntityMapper<MvtStockDTO, MvtStock> {

	@Override
	MvtStock toEntity(MvtStockDTO dto);

	@Override
	MvtStockDTO toDto(MvtStock entity);

	@Override
	List<MvtStock> toEntity(List<MvtStockDTO> dtoList);

	@Override
	List<MvtStockDTO> toDto(List<MvtStock> entityList);

}



