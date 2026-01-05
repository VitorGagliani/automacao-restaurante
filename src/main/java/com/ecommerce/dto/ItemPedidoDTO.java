package com.ecommerce.dto;

import java.math.BigDecimal;

import com.ecommerce.entity.ItemPedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemPedidoDTO {
	
	private Long id;

	private PedidoDTO pedido;
	
	private ProdutoDTO produto;

	private BigDecimal quantidade;

	private String observacao;
	
	public ItemPedidoDTO (ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.pedido = new PedidoDTO(itemPedido.getPedido());
		this.produto = new ProdutoDTO(itemPedido.getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
	}

}
