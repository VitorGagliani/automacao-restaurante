package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.NovoProdutoDTO;
import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Produto;
import com.ecommerce.repository.CategoriaRepository;
import com.ecommerce.repository.ProdutoRepository;

@Service
public class AdicionarProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Produto adicionar (NovoProdutoDTO produtoDto) {
		
		Categoria categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
				.orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
		
		Produto produto = new Produto();
		
		produto.setNome(produtoDto.getNome());
		produto.setDescricao(produtoDto.getDescricao());
		
		//29/12/25
		//reajustar dto intermediario das classes e DTOS para voltar a ter FK 😒
		
		//ajustado
		produto.setCategoria(categoria);
		produto.setImagem(produtoDto.getImagem());
		produto.setPreco(produtoDto.getPreco());
		
		return produtoRepository.save(produto);
		
	}
	
	
}
