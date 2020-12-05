package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;

@Mapper
public interface CategoriaDaoMapper {

	@Insert("INSERT INTO categoria(nombre, descripcion, imagen, estado) VALUES (#{nombre}, #{descripcion}, #{imagen}, #{estado});")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int save(Categoria categoria);
	
	@Select("SELECT * FROM categoria where id = #{id}")
	@Results({
		@Result(property = "productos", column = "id", javaType = List.class, many = @Many(select = "com.mitocode.javaweb.mybatis.producto.infraestructure.persistence.ProductoDaoMapper.findMinByIdCategoria"))
	})
	public Categoria findById(Integer id);
	
	@Select("SELECT * FROM categoria")
	public List<Categoria> findAll();
	
	@Update({"<script>",
	      "UPDATE categoria",
	      "  <set>",
	      "    <if test='nombre != null'>nombre=#{nombre},</if>",
	      "    <if test='descripcion != null'>descripcion=#{descripcion},</if>",
	      "    <if test='imagen != null'>imagen=#{imagen},</if>",
	      "    <if test='estado != null'>estado=#{estado}</if>",
	      "  </set>",
	      "where id=#{id}",
	      "</script>"})
	public int update(Categoria categoria);
	
	@Delete("DELETE FROM categoria WHERE id = #{id}")
	public int delete(Integer id);
	
}
