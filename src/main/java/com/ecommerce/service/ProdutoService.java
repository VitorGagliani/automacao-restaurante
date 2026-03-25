package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.NovoProdutoDTO;
import com.ecommerce.dto.ProdutoDTO;
import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Produto;
import com.ecommerce.enums.ProdutoStatus;
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
		produto.setStatus(ProdutoStatus.ativo);
		
		return produtoRepository.save(produto);
		
	}
	
	public Produto editar(ProdutoDTO produtoDto) {
		System.out.println("Categoria ID: " + produtoDto.getCategoriaId());
		Produto produto = produtoRepository.findById(produtoDto.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrada"));
	    Categoria categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
	            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
		System.out.println("Categoria atribuida: " + categoria);
	    produto.setNome(produtoDto.getNome());
		produto.setDescricao(produtoDto.getDescricao());
		produto.setImagem(produtoDto.getImagem());
		produto.setPreco(produtoDto.getPreco());
		produto.setCategoria(categoria);
		produto.setStatus(produtoDto.getStatus());
		
		return produtoRepository.save(produto);
	}
	
	public Produto ativar(Long id) {
		
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrada"));
	    if(produto.getStatus() == ProdutoStatus.ativo) {
			produto.setStatus(ProdutoStatus.inativo);
	    }else if(
	    produto.getStatus() == ProdutoStatus.inativo) {
			produto.setStatus(ProdutoStatus.ativo);
	    }
		return produtoRepository.save(produto);
	}
	
	
	public List<ListarProdutosMenu> listar(Long idCategoria){
		return produtoRepository.listarProdutos(idCategoria).stream().map(produto -> new ListarProdutosMenu(
				produto.id(),
				produto.imagem(),
				produto.nome(),
				produto.preco(),
				produto.descricao(),
				produto.status()
				)).toList();
		
		
	}
	
	public List<ListarProdutosMenu> listarTodos(){
		return produtoRepository.listarProdutosTodos().stream().map(produto -> new ListarProdutosMenu(
				produto.id(),
				produto.imagem(),
				produto.nome(),
				produto.preco(),
				produto.descricao(),
				produto.status()
				)).toList();
		
	}
	
	public List<ProdutoMaisPedido> produtoMaisPedido(){
		return produtoRepository.produtoMaisPedido().stream().map(produto -> new ProdutoMaisPedido(
				produto.id(),
				produto.nome(),
				produto.total()
				)).toList();
	}
	
}
