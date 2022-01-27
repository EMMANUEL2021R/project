package com.emmanuel.gestionstock.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.emmanuel.gestionstock.Dto.ArticleDTO;
import com.emmanuel.gestionstock.model.Article;

@Mapper(componentModel = "spring", uses = {CategorieMapper.class})
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

	@Override
	Article toEntity(ArticleDTO dto);

	@Override
	ArticleDTO toDto(Article entity);

	@Override
	List<Article> toEntity(List<ArticleDTO> dtoList);

	@Override
	List<ArticleDTO> toDto(List<Article> entityList);

}


