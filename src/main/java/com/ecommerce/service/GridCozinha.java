package com.ecommerce.service;

import java.time.LocalDateTime;

public record GridCozinha(
	Long id,
	String status,
	Long mesa,
	LocalDateTime hora_pedido
		) {}
