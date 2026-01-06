package com.ecommerce.service;

import java.math.BigDecimal;

public record ListaPedidos (
	Long pedidoId,
    String status,
    Long itemId,
    String produto,
    BigDecimal quantidade,
    String observacao
) {}
