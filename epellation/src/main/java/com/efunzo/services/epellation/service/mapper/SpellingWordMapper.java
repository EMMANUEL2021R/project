package com.efunzo.services.epellation.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.efunzo.services.epellation.domaine.SpellingWord;
import com.efunzo.services.epellation.service.dto.SpellingWordDTO;

@Mapper(componentModel = "spring", uses = {LevelMapper.class})
public interface SpellingWordMapper extends EntityMapper<SpellingWordDTO, SpellingWord> {

	@Override
	SpellingWord toEntity(SpellingWordDTO dto);

	@Override
	SpellingWordDTO toDto(SpellingWord entity);

	@Override
	List<SpellingWord> toEntity(List<SpellingWordDTO> dtoList);

	@Override
	List<SpellingWordDTO> toDto(List<SpellingWord> entityList);

}
