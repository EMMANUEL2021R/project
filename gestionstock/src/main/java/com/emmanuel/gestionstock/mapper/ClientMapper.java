package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.ClientDTO;
import com.emmanuel.gestionstock.model.Client;



@Mapper(componentModel = "spring", uses = {CommandeClientMapper.class})
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {

	@Override
	Client toEntity(ClientDTO dto);

	@Override
	ClientDTO toDto(Client entity);

	@Override
	List<Client> toEntity(List<ClientDTO> dtoList);

	@Override
	List<ClientDTO> toDto(List<Client> entityList);

}