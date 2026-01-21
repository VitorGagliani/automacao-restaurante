package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.entity.Categoria;
import com.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	public Categoria criar(CategoriaDTO categoriaDto) {
		Categoria categoria = new Categoria();
		if(categoriaDto.getNome() == null) {
			categoriaDto.setNome("");
		}
		return categoriaRepository.save(categoria);
	}
}
