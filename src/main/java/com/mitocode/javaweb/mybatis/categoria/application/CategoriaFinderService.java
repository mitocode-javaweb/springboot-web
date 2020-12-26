package com.mitocode.javaweb.mybatis.categoria.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaRepository;
import com.mitocode.javaweb.mybatis.categoria.domain.exception.CategoriaNotFoundException;

@Service
public class CategoriaFinderService {

	private CategoriaRepository categoriaRepository;

	public CategoriaFinderService(@Qualifier("categoriaJpaRepository") CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> findById(Integer id) throws CategoriaNotFoundException {
		return Optional.ofNullable(categoriaRepository.findById(id).orElseThrow(CategoriaNotFoundException::new));
	}
	
}
