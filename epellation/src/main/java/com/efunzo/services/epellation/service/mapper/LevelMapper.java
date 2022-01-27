package com.efunzo.services.epellation.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.efunzo.services.epellation.domaine.Level;
import com.efunzo.services.epellation.service.dto.LevelDTO;

@Mapper(
		componentModel = "spring")
public interface LevelMapper  extends EntityMapper<LevelDTO, Level> {
	
 
	@Override
	Level toEntity(LevelDTO dto);
	
	@Override
	LevelDTO toDto(Level entity);
	
	@Override
	List<Level> toEntity(List<LevelDTO> dtoList);
	
	@Override
	List<LevelDTO> toDto(List<Level> entityList);
  
}
