package com.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.CategoriaDTO;
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
}
