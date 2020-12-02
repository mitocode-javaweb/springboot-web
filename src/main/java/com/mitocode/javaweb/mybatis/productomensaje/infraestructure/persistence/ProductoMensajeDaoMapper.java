package com.mitocode.javaweb.mybatis.productomensaje.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.mybatis.productomensaje.domain.ProductoMensaje;

@Mapper
public interface ProductoMensajeDaoMapper {

	@Select("SELECT * FROM producto_mensaje WHERE id_producto = #{idProducto}")
	@Result(column = "nombre_usuario", property = "nombreUsuario")
	public List<ProductoMensaje> findByIdProducto(Integer idProducto);
}
