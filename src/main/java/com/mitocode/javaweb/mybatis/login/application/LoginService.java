package com.mitocode.javaweb.mybatis.login.application;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.login.domain.exception.BadCredentialsException;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;

@Service
public class LoginService {

	private UsuarioRepository usuarioRepository;
	
	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void validarUsuarioClave(String usuario, String clave) throws BadCredentialsException {
		boolean resultado = usuarioRepository.login(usuario, clave);
		
		if(!resultado) {
			throw new BadCredentialsException();
		} else {
			// validar estado del usuario
		}
	}
}
