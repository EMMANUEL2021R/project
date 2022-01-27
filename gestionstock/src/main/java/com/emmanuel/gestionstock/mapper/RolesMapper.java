package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.RolesDTO;
import com.emmanuel.gestionstock.model.Roles;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class})
public interface RolesMapper extends EntityMapper<RolesDTO, Roles> {

	@Override
	Roles toEntity(RolesDTO dto);

	@Override
	RolesDTO toDto(Roles entity);

	@Override
	List<Roles> toEntity(List<RolesDTO> dtoList);

	@Override
	List<RolesDTO> toDto(List<Roles> entityList);

}



