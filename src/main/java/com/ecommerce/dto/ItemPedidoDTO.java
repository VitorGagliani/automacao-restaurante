package com.ecommerce.dto;

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

	private Long idPedido;
	
	private Long idProduto;

	private int quantidade;

	private String observacao;
	
	public ItemPedidoDTO (ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.idPedido = itemPedido.getIdPedido();
		this.idProduto = itemPedido.getIdPedido();
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
	}

}
