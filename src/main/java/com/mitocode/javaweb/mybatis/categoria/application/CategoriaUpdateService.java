package com.mitocode.javaweb.mybatis.categoria.application;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaRepository;

@Service
public class CategoriaUpdateService {

	private CategoriaRepository categoriaRepository;

	public CategoriaUpdateService(@Qualifier("categoriaJpaRepository") CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public int update(Categoria categoria) {
		return categoriaRepository.update(categoria);
	}
	
}
