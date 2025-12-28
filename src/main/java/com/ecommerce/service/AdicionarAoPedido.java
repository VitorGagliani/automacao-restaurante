package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.ItemPedido;
import com.ecommerce.entity.Pedido;
import com.ecommerce.entity.Produto;
import com.ecommerce.repository.ItemPedidoRepository;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.repository.ProdutoRepository;

@Service
public class AdicionarAoPedido {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public ItemPedido adicionar(Long idPedido, Long idProduto, int quantidade, String observacao) {
		Pedido pedido = pedidoRepository.findById(idPedido)
				.orElseThrow(
						() ->  new RuntimeException("Pedido não encontrado"));
		
		Produto produto = produtoRepository.findById(idProduto)
				.orElseThrow(
						()-> new RuntimeException("Produto não encontrado"));
		
		ItemPedido adicionar = new ItemPedido();
		
		adicionar.setIdPedido(idPedido);
		adicionar.setIdProduto(idProduto);
		if(observacao == null) {
			observacao = "";
		}
		adicionar.setObservacao(observacao);
		
		adicionar.setQuantidade(quantidade);
		
		return itemPedidoRepository.save(adicionar);
		
	}
	
}
