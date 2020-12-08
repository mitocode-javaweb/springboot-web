package com.mitocode.javaweb.mybatis.producto.domain;

import java.util.Optional;

public interface ProductoRepository {

	Optional<Producto> findById(Integer id);
	
}
