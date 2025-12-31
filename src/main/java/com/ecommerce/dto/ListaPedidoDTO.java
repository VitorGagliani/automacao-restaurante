package com.ecommerce.dto;

import com.ecommerce.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaPedidoDTO {
	private Long idMesa;
	private Long nomeCliente;
	private Status status;
}
