package com.mitocode.javaweb.mybatis.productomensaje.infraestructure.dto;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.mitocode.javaweb.mybatis.producto.infraestructure.dto.ProductoEntityMapper;
import com.mitocode.javaweb.mybatis.productomensaje.domain.ProductoMensaje;
import com.mitocode.javaweb.mybatis.productomensaje.infraestructure.persistence.ProductoMensajeEntity;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductoEntityMapper.class})
public interface ProductoMensajeEntityMapper {

//	@Mapping(target = "producto", source = "producto")
	ProductoMensaje toProductoMensaje(ProductoMensajeEntity entity, @Context CycleAvoidingMappingContext context);
	
	@Mapping(target = "producto", ignore = true)
	ProductoMensajeEntity toEntity(ProductoMensaje productoMensaje, @Context CycleAvoidingMappingContext context);
	
	List<ProductoMensaje> toProductosMensajes(List<ProductoMensajeEntity> entities, @Context CycleAvoidingMappingContext context);
	
	List<ProductoMensajeEntity> toEntities(List<ProductoMensaje> productoMensajes, @Context CycleAvoidingMappingContext context);
}
