package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;

@Mapper
public interface CategoriaDaoMapper {

	@Insert("INSERT INTO categoria(nombre, descripcion, imagen, estado) VALUES (#{nombre}, #{descripcion}, #{imagen}, #{estado});")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int save(Categoria categoria);
	
	@Select("SELECT * FROM categoria where id = ${id}")
	public Categoria findById(Integer id);
	
	@Select("SELECT * FROM categoria")
	public List<Categoria> findAll();
	
}
