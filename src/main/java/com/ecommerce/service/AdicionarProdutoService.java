package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.entity.Produto;
import com.ecommerce.repository.ProdutoRepository;

@Service
public class AdicionarProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto adicionar (ProdutoDTO produtoDto) {
		Produto produto = new Produto();
		
		produto.setNome(produtoDto.getNome());
		produto.setDescricao(produtoDto.getDescricao());
		
		//29/12/25
		//reajustar entity das classes e DTOS para voltar a ter FK 😒
		produto.setCategoria(produtoDto.getCategoria());
		produto.setImagem(produtoDto.getImagem());
		produto.setPreco(produtoDto.getPreco());
		
		return produtoRepository.save(produto);
		
	}
	
	
}
