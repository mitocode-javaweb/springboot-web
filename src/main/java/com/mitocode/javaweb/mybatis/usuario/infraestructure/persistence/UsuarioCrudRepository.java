package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioEntity, Integer>  {

	Optional<UsuarioEntity> findByUsuario(String usuario);

//	Optional<UsuarioEntity> findByUsuarioAndClave(String usuario, String clave);
	
	@Query("SELECT u FROM UsuarioEntity u WHERE u.usuario = ?1 AND u.clave = ?2")
	Optional<UsuarioEntity> consultarUsuarioClave(String usuario, String clave);

}
