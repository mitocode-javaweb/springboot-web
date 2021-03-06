package com.mitocode.javaweb.mybatis.categoria.application;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaRepository;

@Service
public class CategoriaCreateService {

	private CategoriaRepository categoriaRepository;

	public CategoriaCreateService(@Qualifier("categoriaJpaRepository") CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public int save(Categoria categoria) {
		int row = categoriaRepository.save(categoria);

		return row;
	}
}
