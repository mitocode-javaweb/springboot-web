package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;

@SpringBootTest
@Transactional
public class CategoriaDaoMapperTest {
	
	private static final Logger log = LoggerFactory.getLogger(CategoriaDaoMapperTest.class);
	
	@Autowired
	private CategoriaDaoMapper categoriaDaoMapper;
	
	@Test
	@Commit
	public void registrarCategoria() throws IOException {
		byte[] imagen = Files.readAllBytes(Paths.get("src/test/resources/static/img/Dormitorio.jpg"));
		
		Categoria categoria = new Categoria();
		categoria.setNombre("Dormitorios");
		categoria.setDescripcion("Categoría de dormitorio y productos de decoración");
		categoria.setImagen(imagen);
		
		int rows = categoriaDaoMapper.save(categoria);
		
		assertTrue(rows > 0);
		assertNotNull(categoria.getId());
		
		log.debug(categoria.toString());
		log.debug(categoria.getImagen().toString());
	}
	
}
