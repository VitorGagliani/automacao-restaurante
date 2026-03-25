package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping(value = "/editar")
	public Produto editar(@RequestBody ProdutoDTO produto) {
		return adicionar.editar(produto);
	}
	
	@PutMapping("/ativar/{id}")
	public ResponseEntity<?> ativa(@PathVariable Long id) {
	    try {
	        adicionar.ativar(id);
	        return ResponseEntity.noContent().build();
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
	
	@GetMapping(value = "/listar/{idCategoria}")
	public List<ListarProdutosMenu> listar(@PathVariable("idCategoria") Long idCategoria, ProdutoDTO produto){
		return adicionar.listar(idCategoria);
	}
	
	@GetMapping(value = "/listar-produtos")
	public List<ListarProdutosMenu> listar(Produto produto){
		return adicionar.listarTodos();
	}
	
}
