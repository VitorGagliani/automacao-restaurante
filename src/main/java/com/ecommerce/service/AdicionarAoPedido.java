package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.AdicionarProdutoDTO;
import com.ecommerce.entity.ItemPedido;
import com.ecommerce.entity.Mesa;
import com.ecommerce.entity.Pedido;
import com.ecommerce.entity.Produto;
import com.ecommerce.enums.Status;
import com.ecommerce.enums.StatusMesa;
import com.ecommerce.repository.ItemPedidoRepository;
import com.ecommerce.repository.MesaRepository;
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
	
	@Autowired
	MesaRepository mesaRepository;
	
	public ItemPedido adicionar(AdicionarProdutoDTO produto) {
		Pedido pedido = pedidoRepository.findById(produto.getIdPedido())
				.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
		Produto novoProduto = produtoRepository.findById(produto.getIdProduto())
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		Mesa mesaPedido = mesaRepository.findById(produto.getMesa()).orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
		
		ItemPedido item = new ItemPedido();
		item.setPedido(pedido);
		item.setMesa(mesaPedido);
		item.setStatus(Status.Aberto);
		item.setProduto(novoProduto);
		if(produto.getObservacao() == null) {
			produto.setObservacao("");
		}else {
			item.setObservacao(produto.getObservacao());
		}
		item.setQuantidade(produto.getQuantidade());
		
		return itemPedidoRepository.save(item);
		
	}
	
	
	public ItemPedido preparar(Long id) {
			
			
			ItemPedido comanda = itemPedidoRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
			
			if(comanda.getStatus() == Status.Finalizado) {
				throw new RuntimeException("Pedido já foi finalizado");
			}
			
			
			comanda.setStatus(Status.EmPreparo);
			
	
			
			return itemPedidoRepository.save(comanda);
			
	}
	
	
	
	public ItemPedido fechar(Long id) {
			
			
			ItemPedido comanda = itemPedidoRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
			
			if(comanda.getStatus() == Status.Finalizado) {
				throw new RuntimeException("Pedido já foi finalizado");
			}
			
			
			comanda.setStatus(Status.Finalizado);
			
	
			
			return itemPedidoRepository.save(comanda);
			
		}
	
	
}
