package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.CommandeClientDTO;
import com.emmanuel.gestionstock.model.CommandeClient;
	


@Mapper(componentModel = "spring", uses = {LigneCommandeClientMapper.class})
public interface CommandeClientMapper extends EntityMapper<CommandeClientDTO, CommandeClient> {

	@Override
	CommandeClient toEntity(CommandeClientDTO dto);

	@Override
	CommandeClientDTO toDto(CommandeClient entity);

	@Override
	List<CommandeClient> toEntity(List<CommandeClientDTO> dtoList);

	@Override
	List<CommandeClientDTO> toDto(List<CommandeClient> entityList);

}


