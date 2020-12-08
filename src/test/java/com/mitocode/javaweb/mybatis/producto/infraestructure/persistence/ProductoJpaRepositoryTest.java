package com.mitocode.javaweb.mybatis.producto.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitocode.javaweb.mybatis.producto.domain.Producto;

@SpringBootTest
public class ProductoJpaRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(ProductoJpaRepositoryTest.class);

	@Autowired
	private ProductoJpaRepository productoJpaRepository;
	
	@Test
	public void consultarProducto() {
		Optional<Producto> producto = productoJpaRepository.findById(1);
		
		assertTrue(producto.isPresent());
		
		log.info(producto.toString());
		
	}
}
