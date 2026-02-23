package com.ecommerce.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ecommerce.entity.Mesa;
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
	
	private MesaDTO mesa;
	
	private ClienteDTO clienteDTO;
	
	private Status status;
	
	private LocalDate dataHora;
	
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.mesa = new MesaDTO(pedido.getMesa());
		this.status = pedido.getStatus();
		this.dataHora = pedido.getDataHora();
		
	}
	

}
