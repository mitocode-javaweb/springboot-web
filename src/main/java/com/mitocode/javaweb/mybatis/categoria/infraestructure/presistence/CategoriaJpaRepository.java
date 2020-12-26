package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaRepository;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaEntityMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@Repository
public class CategoriaJpaRepository implements CategoriaRepository {

	private CategoriaCrudRepository categoriaCrudRepository;
	
	private CategoriaEntityMapper categoriaEntityMapper;
	
	private CycleAvoidingMappingContext context;
	
	public CategoriaJpaRepository(CategoriaCrudRepository categoriaCrudRepository,
			CategoriaEntityMapper categoriaEntityMapper) {
		this.categoriaCrudRepository = categoriaCrudRepository;
		this.categoriaEntityMapper = categoriaEntityMapper;
		this.context = new CycleAvoidingMappingContext();
	}

	@Override
	public int save(Categoria categoria) {
		CategoriaEntity entity = categoriaCrudRepository.save(categoriaEntityMapper.toEntity(categoria));
		categoria.setId(entity.getId());
		
		return entity == null ? 0 : 1;
	}

	@Override
	public Optional<Categoria> findById(Integer id) {
		context = new CycleAvoidingMappingContext();
		return categoriaCrudRepository.findById(id).map(entity -> categoriaEntityMapper.toCategoria(entity, context));
	}

	@Override
	public List<Categoria> findAll() {
		context = new CycleAvoidingMappingContext();
		return categoriaEntityMapper.toCategorias(
					StreamSupport
						.stream(categoriaCrudRepository.findAll(Sort.by("id").ascending()).spliterator(), false)
						.collect(Collectors.toList()), context);
	}

	@Override
	public int update(Categoria categoria) {
		CategoriaEntity entity = categoriaCrudRepository.findById(categoria.getId()).get();
		
//		if(categoria.getImagen() != null) {
//			entity.setImagen(categoria.getImagen());
//		}		
		categoriaEntityMapper.updateEntityFromDomain(categoria, entity);
		
		entity = categoriaCrudRepository.save(entity);
		
		return entity == null ? 0 : 1;
	}

	@Override
	public int delete(Integer id) {
		categoriaCrudRepository.deleteById(id);
		return 1;
	}

}
