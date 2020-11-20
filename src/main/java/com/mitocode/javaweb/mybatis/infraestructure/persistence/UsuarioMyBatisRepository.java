package com.mitocode.javaweb.mybatis.infraestructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.mybatis.domain.Usuario;
import com.mitocode.javaweb.mybatis.domain.UsuarioRepository;

@Repository
public class UsuarioMyBatisRepository implements UsuarioRepository {
	
	private UsuarioDaoMapper usuarioDaoMapper;
	
	public UsuarioMyBatisRepository(UsuarioDaoMapper usuarioDaoMapper) {
		this.usuarioDaoMapper = usuarioDaoMapper;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDaoMapper.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return null;
	}

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return Optional.of(usuarioDaoMapper.findByUsuario(usuario));
	}

	@Override
	public int save(Usuario usuario) {
		return usuarioDaoMapper.save(usuario);
	}

	@Override
	public boolean login(String usuario, String clave) {
		return false;
	}

}
