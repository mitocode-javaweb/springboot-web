package com.mitocode.javaweb.mybatis.producto.infraestructure.dto;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;
import com.mitocode.javaweb.mybatis.producto.domain.Producto;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoriaDtoMapper.class})
public interface ProductoDtoMapper {
	
	public ProductoDto toProductoDto(Producto producto, @Context CycleAvoidingMappingContext context);
	
	@Mapping(target = "mensajes", ignore = true)
	public Producto toProducto(ProductoDto productoDto, @Context CycleAvoidingMappingContext context);
	
	public List<ProductoDto> toProductoDtos(List<Producto> productos, @Context CycleAvoidingMappingContext context);
	
	public List<Producto> toProductos(List<ProductoDto> productoDtos, @Context CycleAvoidingMappingContext context);
	
}
