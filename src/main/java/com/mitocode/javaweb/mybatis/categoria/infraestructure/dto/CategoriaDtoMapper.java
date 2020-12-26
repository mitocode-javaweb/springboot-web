package com.mitocode.javaweb.mybatis.categoria.infraestructure.dto;

import java.io.IOException;
import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.producto.infraestructure.dto.ProductoDtoMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@Mapper(componentModel = "spring", uses = ProductoDtoMapper.class)
public interface CategoriaDtoMapper {

	@Mappings({
		@Mapping(target = "productos", ignore = true),
		@Mapping(target = "imagen", source = "fileImagen.bytes")
	})
	Categoria toCategoria(CategoriaDto categoriaDto, @Context CycleAvoidingMappingContext context)  throws IOException;

	@Mappings({
		@Mapping(target = "fileImagen", ignore = true), @Mapping(target = "imagenUrl", ignore = true),
		@Mapping(target = "estadoDescripcion", source = "estado.descripcion")
	})
	CategoriaDto toCategoriaDto(Categoria categoria, @Context CycleAvoidingMappingContext context);

	List<Categoria> toCategorias(List<CategoriaDto> categoriaDtos, @Context CycleAvoidingMappingContext context);

	List<CategoriaDto> toCategoriaDtos(List<Categoria> categorias, @Context CycleAvoidingMappingContext context);
	
}
