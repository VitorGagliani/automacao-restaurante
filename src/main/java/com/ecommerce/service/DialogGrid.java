package com.ecommerce.service;

import java.math.BigDecimal;

public record DialogGrid(
		Long item_codigo,
		String produto,
		BigDecimal quantidade_produto,
		String observacao_produto
		) {}
