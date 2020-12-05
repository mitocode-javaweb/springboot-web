package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;

@SpringBootTest
public class UsuarioDaoMapperTest {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioDaoMapperTest.class);

	@Autowired
	private UsuarioDaoMapper usuarioDaoMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Test
	@Disabled
	public void actualizarClave() {
		Usuario usuario = usuarioDaoMapper.findById(9);
		usuario.setClaveUsuario(passwordEncoder.encode("123"));
		
		int row = usuarioDaoMapper.update(usuario);
		
		assertTrue(row > 0);
		
		log.debug(usuario.toString());
	}
}
