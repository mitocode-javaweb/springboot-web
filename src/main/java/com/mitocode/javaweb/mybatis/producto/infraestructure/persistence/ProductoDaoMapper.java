package com.mitocode.javaweb.mybatis.producto.infraestructure.persistence;

import java.awt.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.producto.domain.Producto;

@Mapper
public interface ProductoDaoMapper {

	@Select("SELECT * FROM producto WHERE id = #{id}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "nombreCorto", column = "nombre_corto"),
		@Result(property = "nombreExtenso", column = "nombre_extenso"),
		@Result(property = "descripcionCorta", column = "descripcion_corta"),
		@Result(property = "descripcionExtensa", column = "descripcion_extensa"),
		@Result(property = "categoria", 
				column = "id_categoria", 
				javaType = Categoria.class,
				one = @One(select = "com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence.CategoriaDaoMapper.findById")
		),
		@Result(property = "mensajes", 
				column = "id", 
				javaType = List.class,
				many = @Many(select = "com.mitocode.javaweb.mybatis.productomensaje.infraestructure.persistence.ProductoMensajeDaoMapper.findByIdProducto")
		)
	})
	public Producto findById(Integer id);
	
}
