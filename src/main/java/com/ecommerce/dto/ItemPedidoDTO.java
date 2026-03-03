package com.ecommerce.dto;

import java.math.BigDecimal;

import com.ecommerce.entity.ItemPedido;
import com.ecommerce.enums.Status;

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

	private MesaDTO mesa;
	
	private BigDecimal quantidade;

	private String observacao;
	
	private Status status;
	

}
