package com.mitocode.javaweb.mybatis.categoria.application;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaRepository;

@Service
public class CategoriaDeleteService {

	private CategoriaRepository categoriaRepository;

	public CategoriaDeleteService(@Qualifier("categoriaJpaRepository") CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public int delete(Integer id) {
		return categoriaRepository.delete(id);
	}
}
