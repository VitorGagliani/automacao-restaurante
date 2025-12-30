package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.NovoProdutoDTO;
import com.ecommerce.entity.Produto;
import com.ecommerce.repository.ProdutoRepository;
import com.ecommerce.service.AdicionarProdutoService;

@RestController
@RequestMapping (value = "/produto")
public class ProdutoController {


	@Autowired
	AdicionarProdutoService adicionar;
	
	@PostMapping(value = "/novo")
	public Produto criar(@RequestBody NovoProdutoDTO produto) {
		return adicionar.adicionar(produto);
	}
	
	
}
