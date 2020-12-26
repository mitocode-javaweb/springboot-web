package com.mitocode.javaweb.mybatis.categoria.infraestructure.dto;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence.CategoriaEntity;
import com.mitocode.javaweb.mybatis.producto.infraestructure.dto.ProductoEntityMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@Mapper(componentModel = "spring", uses = { ProductoEntityMapper.class })
public interface CategoriaEntityMapper {

//	@Mapping(target = "productos", ignore = true)
	Categoria toCategoria(CategoriaEntity entity, @Context CycleAvoidingMappingContext context);

	@InheritInverseConfiguration
	CategoriaEntity toEntity(Categoria categoria);

	@Mapping(target = "productos", ignore = true)
	List<Categoria> toCategorias(List<CategoriaEntity> entities, @Context CycleAvoidingMappingContext context);

	List<CategoriaEntity> toEntities(List<Categoria> categorias);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "productos", ignore = true)
	void updateEntityFromDomain(Categoria categoria, @MappingTarget CategoriaEntity entity);

}
