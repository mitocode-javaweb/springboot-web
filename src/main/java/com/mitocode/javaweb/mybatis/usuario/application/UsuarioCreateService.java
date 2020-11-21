package com.mitocode.javaweb.mybatis.usuario.application;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.dto.UsuarioDtoMapper;

@Service
public class UsuarioCreateService {

	private UsuarioRepository usuarioRepository;
	
	private UsuarioDtoMapper usuarioDtoMapper;

	public UsuarioCreateService(UsuarioRepository usuarioRepository, UsuarioDtoMapper usuarioDtoMapper) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioDtoMapper = usuarioDtoMapper;
	}
	
	public int save(UsuarioDto usuarioDto) {
		Usuario usuario = usuarioDtoMapper.toUsuario(usuarioDto);
		int result = usuarioRepository.save(usuario);
		
		if(result > 0) {
			usuarioDto.setId(usuario.getId());
		}
		return result;
	}

}
