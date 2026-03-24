package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.entity.Categoria;
import com.ecommerce.repository.CategoriaRepository;
import com.ecommerce.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
	
	@GetMapping(value = "/listar")
		public List<CategoriaDTO> ListarCategorias(CategoriaDTO categoria){
		return categoriaService.listarCategoria();
	}
	
	@PostMapping(value = "/novo")
	public Categoria criarCategoria(@RequestBody  CategoriaDTO cateogoriaDto) {
		return categoriaService.criar(cateogoriaDto);
	}
	
	
	@PutMapping(value = "/editar")
	public Categoria editaCategoria(@RequestBody CategoriaDTO categoria) {
		return categoriaService.editar(categoria);
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
	    try {
	        categoriaService.deletar(id);
	        return ResponseEntity.noContent().build();
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
}
