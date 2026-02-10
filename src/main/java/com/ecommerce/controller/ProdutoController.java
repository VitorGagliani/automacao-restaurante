package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.NovoProdutoDTO;
import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.entity.Produto;
import com.ecommerce.repository.ProdutoRepository;
import com.ecommerce.service.ListarProdutosMenu;
import com.ecommerce.service.ProdutoService;

@RestController
@RequestMapping (value = "/produto")
public class ProdutoController {


	@Autowired
	ProdutoService adicionar;
	
	@PostMapping(value = "/novo")
	public Produto criar(@RequestBody NovoProdutoDTO produto) {
		return adicionar.adicionar(produto);
	}
	
	@GetMapping(value = "/listar/{idCategoria}")
	public List<ListarProdutosMenu> listar(@PathVariable("idCategoria") Long idCategoria, ProdutoDTO produto){
		return adicionar.listar(idCategoria);
	}
	
}
