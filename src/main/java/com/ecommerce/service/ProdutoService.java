package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.NovoProdutoDTO;
import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Produto;
import com.ecommerce.repository.CategoriaRepository;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.repository.ProdutoRepository;


//Criar produto

@Service
public class ProdutoService {

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
	
	public List<ListarProdutosMenu> listar(Long idCategoria){
		return produtoRepository.listarProdutos(idCategoria).stream().map(produto -> new ListarProdutosMenu(
				produto.id(),
				produto.imagem(),
				produto.nome(),
				produto.preco(),
				produto.descricao()
				)).toList();
		
		
	}
	
	public List<ListarProdutosMenu> listarTodos(){
		return produtoRepository.listarProdutosTodos().stream().map(produto -> new ListarProdutosMenu(
				produto.id(),
				produto.imagem(),
				produto.nome(),
				produto.preco(),
				produto.descricao()
				)).toList();
		
	}
	
}
