package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.CommandeFournisseurDTO;
import com.emmanuel.gestionstock.model.CommandeFournisseur;

@Mapper(componentModel = "spring", uses = {LigneCommandeFournisseurMapper.class,FournisseurMapper.class})
public interface CommandeFournisseurMapper extends EntityMapper<CommandeFournisseurDTO, CommandeFournisseur> {

	@Override
	CommandeFournisseur toEntity(CommandeFournisseurDTO dto);

	@Override
	CommandeFournisseurDTO toDto(CommandeFournisseur entity);

	@Override
	List<CommandeFournisseur> toEntity(List<CommandeFournisseurDTO> dtoList);

	@Override
	List<CommandeFournisseurDTO> toDto(List<CommandeFournisseur> entityList);

}


