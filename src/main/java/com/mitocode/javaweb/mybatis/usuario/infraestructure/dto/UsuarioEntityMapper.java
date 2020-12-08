package com.mitocode.javaweb.mybatis.usuario.infraestructure.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence.UsuarioEntity;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

	@Mapping(source = "clave", target = "claveUsuario")
	Usuario toUsuario(UsuarioEntity usuarioEntity);

	@InheritInverseConfiguration
	UsuarioEntity toEntity(Usuario usuario);

	List<Usuario> toUsuarios(List<UsuarioEntity> usuarioEntities);

	List<UsuarioEntity> toEntities(List<Usuario> usuario);

}
