package com.mitocode.javaweb.mybatis.application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioCreateService;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;

@SpringBootTest
@Transactional
public class UsuarioCreateServiceTest {

	private static final Logger log = LoggerFactory.getLogger(UsuarioCreateServiceTest.class);

	@Autowired
	private UsuarioCreateService usuarioCreateService;

	@Test
//	@Commit // Sirve para confirmar la transaccion
	public void crearUsuarioCOnTodosLosCampos() {
		UsuarioDto dto = new UsuarioDto();
		dto.setUsuario("diegojoel");
		dto.setNombres("Diego Requejo");
		dto.setClave("123");

		int filas = usuarioCreateService.save(dto);

		assertNotEquals(0, filas);
		assertNotNull(dto.getId());

		log.debug(dto.toString());

	}
}
