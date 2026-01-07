package com.ecommerce.service;

import java.math.BigDecimal;

public record ListaPedidoMenu(
		Long pedidoId,
		String nome,
		String produtoImagem,
		BigDecimal quantidade,
		String observacao
		) {}
