package com.mitocode.javaweb.mybatis.usuario.application;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;

@Service
public class UsuarioCreateService {

	private UsuarioRepository usuarioRepository;

	public UsuarioCreateService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public int save(Usuario usuario) {
		int result = usuarioRepository.save(usuario);

		if (result > 0) {
			usuario.setId(usuario.getId());
		}
		return result;
	}

}
