package com.mitocode.javaweb.mybatis.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.domain.Usuario;
import com.mitocode.javaweb.mybatis.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.domain.exception.UsuarioNotFoundException;

@Service
public class UsuarioFinderService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioFinderService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findByUsuario(String usuario) throws UsuarioNotFoundException {
		return usuarioRepository.findByUsuario(usuario).orElseThrow(UsuarioNotFoundException::new);
	}
}
