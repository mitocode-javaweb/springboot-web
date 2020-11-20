package com.mitocode.javaweb.mybatis.application;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.domain.Usuario;
import com.mitocode.javaweb.mybatis.domain.UsuarioRepository;

@Service
public class UsuarioCreateService {

	private UsuarioRepository usuarioRepository;

	public UsuarioCreateService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public int save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
