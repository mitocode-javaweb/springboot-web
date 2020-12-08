package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;

@SpringBootTest
public class UsuarioJpaRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(UsuarioJpaRepositoryTest.class);

	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	
	@Test
	public void buscarPorUsuario() {
		Optional<Usuario> usuario = usuarioJpaRepository.findByUsuario("juanpablo@mitocodenetwork.com");
		
		assertTrue(usuario.isPresent());
		
		log.info(usuario.toString());
	}
	
	@Test
	public void login() {
		boolean usuario = usuarioJpaRepository.login("emilio@mitocodenetwork.com", "123");
		
		assertTrue(usuario);
		
	}
}
