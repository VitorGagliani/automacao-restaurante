package com.ecommerce.service;

import java.math.BigDecimal;

public record ListaPedidoMenu(
		Long pedidoId,
		String nome,
		String produtoImagem,
		BigDecimal preco,
		BigDecimal quantidade,
		String observacao
		) {}
