package com.mitocode.javaweb.mybatis.categoria.domain;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
	
	public int save(Categoria categoria);
	
	public Optional<Categoria> findById(Integer id);
	
	public List<Categoria> findAll();
	
	public int update(Categoria categoria);
	
	public int delete(Integer id);

}
