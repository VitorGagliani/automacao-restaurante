package com.ecommerce.service;

import java.time.LocalDate;

public record GridCozinha(
	Long id,
	String status,
	Long mesa,
	LocalDate hora_pedido
		) {}
