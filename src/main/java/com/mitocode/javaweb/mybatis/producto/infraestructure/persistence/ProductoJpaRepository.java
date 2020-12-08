package com.mitocode.javaweb.mybatis.producto.infraestructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.mybatis.producto.domain.Producto;
import com.mitocode.javaweb.mybatis.producto.domain.ProductoRepository;
import com.mitocode.javaweb.mybatis.producto.infraestructure.dto.ProductoEntityMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@Repository
public class ProductoJpaRepository implements ProductoRepository {

	private ProductoCrudRepository productoCrudRepository;
	
	private ProductoEntityMapper productoEntityMapper;
	
	private CycleAvoidingMappingContext context;

	public ProductoJpaRepository(ProductoCrudRepository productoCrudRepository,
			ProductoEntityMapper productoEntityMapper) {
		this.productoCrudRepository = productoCrudRepository;
		this.productoEntityMapper = productoEntityMapper;
		this.context = new CycleAvoidingMappingContext();
	}

	@Override
	public Optional<Producto> findById(Integer id) {
		context = new CycleAvoidingMappingContext();
		return productoCrudRepository.findById(id).map(prod -> productoEntityMapper.toProducto(prod, context));
	}
	
	
	
}
