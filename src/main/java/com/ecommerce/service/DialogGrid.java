package com.ecommerce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DialogGrid(
		Long pedido_id,
		String status,
		String produto,
		BigDecimal quantidade_produto,
		String observacao_produto,
		LocalDateTime data
		) {}
