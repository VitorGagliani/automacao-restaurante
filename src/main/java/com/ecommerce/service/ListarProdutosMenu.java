package com.ecommerce.service;

import java.math.BigDecimal;

public record ListarProdutosMenu(
		String imagem,
		String nome,
		BigDecimal preco,
		String descricao
		) {}