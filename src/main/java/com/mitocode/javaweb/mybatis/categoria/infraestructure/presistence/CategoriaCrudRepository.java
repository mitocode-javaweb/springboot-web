package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaCrudRepository extends PagingAndSortingRepository<CategoriaEntity, Integer> {

}
