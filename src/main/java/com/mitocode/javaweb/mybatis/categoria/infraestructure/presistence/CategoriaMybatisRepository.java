package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaRepository;

@Repository
public class CategoriaMybatisRepository implements CategoriaRepository{

	private CategoriaDaoMapper categoriaDaoMapper;
	
	public CategoriaMybatisRepository(CategoriaDaoMapper categoriaDaoMapper) {
		this.categoriaDaoMapper = categoriaDaoMapper;
	}

	@Override
	public int save(Categoria categoria) {
		return categoriaDaoMapper.save(categoria);
	}

	@Override
	public Optional<Categoria> findById(Integer id) {
		return Optional.ofNullable(categoriaDaoMapper.findById(id));
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaDaoMapper.findAll();
	}

	@Override
	public int update(Categoria categoria) {
		return categoriaDaoMapper.update(categoria);
	}

	@Override
	public int delete(Integer id) {
		return categoriaDaoMapper.delete(id);
	}
	
}
