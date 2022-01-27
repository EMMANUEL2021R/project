package com.efunzo.services.epellation.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.efunzo.services.epellation.domaine.SpellingSession;
import com.efunzo.services.epellation.service.dto.SpellingSessionDTO;

@Mapper(componentModel = "spring", uses= {EpellationUserMapper.class})
public interface SpellingSessionMapper extends EntityMapper<SpellingSessionDTO, SpellingSession> {

	@Override
	SpellingSession toEntity(SpellingSessionDTO dto);

	@Override
	SpellingSessionDTO toDto(SpellingSession entity);

	@Override
	List<SpellingSession> toEntity(List<SpellingSessionDTO> dtoList);

	@Override
	List<SpellingSessionDTO> toDto(List<SpellingSession> entityList);

}
