package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.UtilisateurDTO;
import com.emmanuel.gestionstock.model.Utilisateur;

@Mapper(componentModel = "spring", uses = {RolesMapper.class,EntrepriseMapper.class,AdresseMapper.class})
public interface UtilisateurMapper extends EntityMapper<UtilisateurDTO, Utilisateur> {

	@Override
	Utilisateur toEntity(UtilisateurDTO dto);

	@Override
	UtilisateurDTO toDto(Utilisateur entity);

	@Override
	List<Utilisateur> toEntity(List<UtilisateurDTO> dtoList);

	@Override
	List<UtilisateurDTO> toDto(List<Utilisateur> entityList);

}


