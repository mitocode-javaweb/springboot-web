package com.mitocode.javaweb.mybatis.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioFinderService;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;

@SpringBootTest
public class UsuarioFinderServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioFinderServiceTest.class);

	@Autowired
	private UsuarioFinderService usuarioFinderService;
	
	@Test
	public void obtenerLaListaDeUsuarios() {
		List<UsuarioDto> lista = usuarioFinderService.findAll();
		
		assertFalse(lista.isEmpty());
		
		lista.forEach(dto -> log.debug(dto.toString()));
	}
	
	@Test
	public void consultarPorUsuario() throws UsuarioNotFoundException {
		UsuarioDto usuario = usuarioFinderService.findByUsuario("juanpablo");
		
		assertNotNull(usuario);
		
		log.debug(usuario.toString());
	}

}
