package com.mitocode.javaweb.mybatis.productomensaje.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.mybatis.producto.domain.Producto;
import com.mitocode.javaweb.mybatis.productomensaje.domain.ProductoMensaje;

@Mapper
public interface ProductoMensajeDaoMapper {

	@Select("SELECT * FROM producto_mensaje WHERE id_producto = #{idProducto}")
	@Results({
		@Result(column = "nombre_usuario", property = "nombreUsuario"),
		@Result(
				column = "id_producto", 
				property = "producto", 
				javaType = Producto.class,
				one = @One(select = "com.mitocode.javaweb.mybatis.producto.infraestructure.persistence.ProductoDaoMapper.findMinById"))
	})
	public List<ProductoMensaje> findByIdProducto(Integer idProducto);
}
