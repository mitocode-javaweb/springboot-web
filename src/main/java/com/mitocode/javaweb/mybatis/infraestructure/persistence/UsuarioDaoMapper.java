package com.mitocode.javaweb.mybatis.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.mybatis.domain.Usuario;

@Mapper
public interface UsuarioDaoMapper {

	@Select("SELECT * FROM usuario")
	@Results({
		@Result(column = "clave", property = "claveUsuario")
	})
	public List<Usuario> findAll();
	
	@Select("SELECT * FROM usuario WHERE usuario = #{identificador}")
	@Results({
		@Result(column = "clave", property = "claveUsuario")
	})
	public Usuario findByUsuario(@Param("identificador") String usuario);
	
	@Insert("INSERT INTO usuario(usuario, nombres, clave, estado) VALUES ( #{usuario}, #{nombres}, #{claveUsuario}, #{estado} ) ")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int save(Usuario usuarioInsert);
	
}
