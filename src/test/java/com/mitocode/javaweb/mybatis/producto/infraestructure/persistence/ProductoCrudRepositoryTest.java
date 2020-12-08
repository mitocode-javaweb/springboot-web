package com.mitocode.javaweb.mybatis.producto.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductoCrudRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoCrudRepositoryTest.class);

	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	
	@Test
	public void consultarPorId() {
		Optional<ProductoEntity> producto = productoCrudRepository.findById(1);
		
		assertTrue(producto.isPresent());
		
		log.info(producto.toString());
		
	}
	
}
