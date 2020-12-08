package com.mitocode.javaweb.mybatis.categoria.infraestructure.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence.CategoriaEntity;
import com.mitocode.javaweb.mybatis.producto.infraestructure.dto.ProductoEntityMapper;

@Mapper(componentModel = "spring", uses = { ProductoEntityMapper.class })
public interface CategoriaEntityMapper {

	@Mapping(target = "productos", ignore = true)
	Categoria toCategoria(CategoriaEntity entity);

	@InheritInverseConfiguration
	CategoriaEntity toEntity(Categoria categoria);

	List<Categoria> toCategorias(List<CategoriaEntity> entities);

	List<CategoriaEntity> toEntities(List<Categoria> categorias);

}
