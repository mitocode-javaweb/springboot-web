package com.mitocode.javaweb.mybatis.producto.infraestructure.dto;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaEntityMapper;
import com.mitocode.javaweb.mybatis.producto.domain.Producto;
import com.mitocode.javaweb.mybatis.producto.infraestructure.persistence.ProductoEntity;
import com.mitocode.javaweb.mybatis.productomensaje.infraestructure.dto.ProductoMensajeEntityMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@Mapper(componentModel = "spring", uses = { CategoriaEntityMapper.class, ProductoMensajeEntityMapper.class })
public interface ProductoEntityMapper {

//	@Mapping(target = "mensajes", ignore = true)
	Producto toProducto(ProductoEntity entity, @Context CycleAvoidingMappingContext context);

	@InheritInverseConfiguration
	ProductoEntity toEntity(Producto producto, @Context CycleAvoidingMappingContext context);

}
