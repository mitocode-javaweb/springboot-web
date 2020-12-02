package com.mitocode.javaweb.mybatis.producto.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitocode.javaweb.mybatis.producto.domain.Producto;

@SpringBootTest
public class ProductoDaoMapperTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoDaoMapperTest.class);
	
	@Autowired
	private ProductoDaoMapper productoDaoMapper;

	@Test
	public void consultarProducto() {
		Producto producto = productoDaoMapper.findById(1);
		
		assertNotNull(producto);
		
		log.debug(producto.toString());
	}
	
}
