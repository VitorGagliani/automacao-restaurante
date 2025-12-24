package com.ecommerce.dto;

import java.time.LocalDateTime;

import com.ecommerce.entity.Pedido;
import com.ecommerce.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	
private Long id;
	
	private Long idMesa;
	
	private Long idCliente;
	
	private String clienteNome;

	private String clienteTelefone;
	
	private Status status;
	
	private LocalDateTime dataHora;
	
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.idMesa = pedido.getIdMesa();
		this.idCliente = pedido.getIdCliente();
		this.clienteNome = pedido.getClienteNome();
		this.clienteTelefone = pedido.getClienteTelefone();
		this.status = pedido.getStatus();
		this.dataHora = pedido.getDataHora();
		
	}
	

}
