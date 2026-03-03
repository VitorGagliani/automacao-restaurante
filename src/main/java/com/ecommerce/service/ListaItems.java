package com.ecommerce.service;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public record ListaItems (
		Long id,
		Long pedido_id,
		Long mesa_id,
		String status,
		Long produto_id,
		BigDecimal quantidade,
		String observacao,
		String Produto
		
) {}
