package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.dto.UsuarioEntityMapper;

@Repository
public class UsuarioJpaRepository implements UsuarioRepository {

	private UsuarioCrudRepository usuarioCrudRepository;
	
	private UsuarioEntityMapper usuarioEntityMapper;

	public UsuarioJpaRepository(UsuarioCrudRepository usuarioCrudRepository, UsuarioEntityMapper usuarioEntityMapper) {
		this.usuarioCrudRepository = usuarioCrudRepository;
		this.usuarioEntityMapper = usuarioEntityMapper;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioEntityMapper.toUsuarios(
				StreamSupport
					.stream(usuarioCrudRepository.findAll().spliterator(), false)
					.collect(Collectors.toList())
				);
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioCrudRepository.findById(id)
				.map(entity -> usuarioEntityMapper.toUsuario(entity));
	}

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return usuarioCrudRepository.findByUsuario(usuario)
				.map(entity -> usuarioEntityMapper.toUsuario(entity));
	}

	@Override
	public int save(Usuario usuario) {
		UsuarioEntity entity = usuarioCrudRepository.save(usuarioEntityMapper.toEntity(usuario));
		return entity == null ? 0 : 1;
	}

	@Override
	public boolean login(String usuario, String clave) {
		Optional<UsuarioEntity> entity = usuarioCrudRepository.consultarUsuarioClave(usuario, clave);
		return entity.isPresent();
	}

}
