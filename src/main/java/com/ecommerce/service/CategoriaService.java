package com.ecommerce.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.entity.Categoria;
import com.ecommerce.repository.CategoriaRepository;
import com.ecommerce.repository.ProdutoRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public Categoria criar(CategoriaDTO categoriaDto) {
		Categoria categoria = new Categoria();
		categoria.setNome(categoriaDto.getNome());
		return categoriaRepository.save(categoria);
	}
	
	public Categoria editar(CategoriaDTO categoriaDto) {
		Categoria categoria = categoriaRepository.findById(categoriaDto.getId()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
		categoria.setNome(categoriaDto.getNome());
		return categoriaRepository.save(categoria);
	}
	
	public void deletar(Long id) {

	    if (produtoRepository.existsByCategoriaId(id)) {
	        throw new RuntimeException("Categoria não pode ser deletada pois possui produtos vinculados");
	    }

	    categoriaRepository.deleteById(id);
	}
	
	public List<CategoriaDTO> listarCategoria(){
		return categoriaRepository.listarCategorias();
	}
}
