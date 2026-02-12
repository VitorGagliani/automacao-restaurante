package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query(value = """
			select * from arqcat
			order by id;"""
			, nativeQuery = true)
	List<CategoriaDTO> listarCategorias();
	
}
