package com.mitocode.javaweb.mybatis.usuario.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.dto.UsuarioDtoMapper;

@Service
public class UsuarioFinderService {

	private UsuarioRepository usuarioRepository;
	
	private UsuarioDtoMapper usuarioDtoMapper;
	
	public UsuarioFinderService(UsuarioRepository usuarioRepository, UsuarioDtoMapper usuarioDtoMapper) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioDtoMapper = usuarioDtoMapper;
	}

	public List<UsuarioDto> findAll() {
		return usuarioDtoMapper.toUsuarioDtos(usuarioRepository.findAll());
	}
	
	public UsuarioDto findByUsuario(String usuario) throws UsuarioNotFoundException {
		return usuarioRepository.findByUsuario(usuario)
				.map(usuarioDtoMapper::toUsuarioDto)
				.orElseThrow(UsuarioNotFoundException::new);
	}
}
