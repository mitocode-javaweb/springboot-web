package com.mitocode.javaweb.mybatis.categoria.infraestructure.dto;

import java.util.List;

import org.mapstruct.Mapper;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.dto.CategoriaDto;

@Mapper(componentModel = "spring")
public interface CategoriaDtoMapper {

	Categoria toCategoria(CategoriaDto cateogiraDto);

	CategoriaDto toCategoriaDto(Categoria cateogira);

	List<Categoria> toCategorias(List<CategoriaDto> cateogiraDtos);

	List<CategoriaDto> toCategoriaDtos(List<Categoria> cateogiras);
	
}
