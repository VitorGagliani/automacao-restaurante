package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.AdicionarProdutoDTO;
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
	
	public ItemPedido adicionar(AdicionarProdutoDTO produto) {
		Pedido pedido = pedidoRepository.findById(produto.getIdPedido())
				.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
		Produto novoProduto = produtoRepository.findById(produto.getIdProduto())
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		ItemPedido item = new ItemPedido();
		item.setPedido(pedido);
		item.setProduto(novoProduto);
		item.setObservacao(produto.getObservacao());
		item.setQuantidade(produto.getQuantidade());
		
		return itemPedidoRepository.save(item);
		
	}
	
}
