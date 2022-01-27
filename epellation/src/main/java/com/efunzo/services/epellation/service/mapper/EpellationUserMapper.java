package com.efunzo.services.epellation.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.efunzo.services.epellation.domaine.EpellationUser;
import com.efunzo.services.epellation.domaine.Level;
import com.efunzo.services.epellation.domaine.Role;
import com.efunzo.services.epellation.service.dto.EpellationUserDTO;
import com.efunzo.services.epellation.service.dto.LevelDTO;


@Mapper(
		componentModel = "spring")
public interface EpellationUserMapper  extends EntityMapper<EpellationUserDTO, EpellationUser> {
	
	
	 
		@Override
		EpellationUser toEntity(EpellationUserDTO dto);
		
		@Override
		EpellationUserDTO toDto(EpellationUser entity);
		
		@Override
		List<EpellationUser> toEntity(List<EpellationUserDTO> dtoList);
		
		@Override
		List<EpellationUserDTO> toDto(List<EpellationUser> entityList);
	  
	
}
