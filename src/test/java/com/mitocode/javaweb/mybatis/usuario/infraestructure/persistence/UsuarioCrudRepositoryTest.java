package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioCrudRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(UsuarioCrudRepositoryTest.class);

	@Autowired
	private UsuarioCrudRepository usuarioCrudRepository;
	
	@Test
	public void listarUsuarios() {
		List<UsuarioEntity> entities = (List<UsuarioEntity>) usuarioCrudRepository.findAll();
		
		assertNotNull(entities);
		assertFalse(entities.isEmpty());
		
		entities.forEach(entity -> log.info(entity.toString()));
	}
	
	
}
