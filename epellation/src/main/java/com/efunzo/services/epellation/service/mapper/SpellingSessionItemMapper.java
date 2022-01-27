package com.efunzo.services.epellation.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.efunzo.services.epellation.domaine.SpellingSessionItem;
import com.efunzo.services.epellation.service.dto.SpellingSessionItemDTO;

@Mapper(componentModel = "spring", uses= {SpellingWordMapper.class, SpellingWordMapper.class})
public interface SpellingSessionItemMapper extends EntityMapper<SpellingSessionItemDTO, SpellingSessionItem> {

	@Override
	SpellingSessionItem toEntity(SpellingSessionItemDTO dto);

	@Override
	SpellingSessionItemDTO toDto(SpellingSessionItem entity);

	@Override
	List<SpellingSessionItem> toEntity(List<SpellingSessionItemDTO> dtoList);

	@Override
	List<SpellingSessionItemDTO> toDto(List<SpellingSessionItem> entityList);

}
