package com.ecommerce.service;

import java.math.BigDecimal;

public record ProdutoMaisPedido(
		Long id,
		String nome,
		BigDecimal total
		) {

}
