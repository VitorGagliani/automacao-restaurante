package com.ecommerce.dto;

import java.time.LocalDateTime;

import com.ecommerce.entity.Pedido;
import com.ecommerce.enums.Status;

public class PedidoDTO {
	
private Long id;
	
	private MesaDTO mesa;
	
	private ClienteDTO cliente;
	
	private Status status;
	
	private LocalDateTime dataHora;
	
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.mesa = new MesaDTO(pedido.getMesa());
		this.cliente = new ClienteDTO(pedido.getCliente());
		this.status = pedido.getStatus();
		this.dataHora = pedido.getDataHora();
		
	}
	

}
