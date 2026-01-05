package com.ecommerce.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdicionarProdutoDTO {
	private Long idPedido;
	private Long idProduto;
	private BigDecimal quantidade;
	private String observacao;
}
