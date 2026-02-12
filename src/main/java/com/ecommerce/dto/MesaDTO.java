package com.ecommerce.dto;

import com.ecommerce.entity.Mesa;
import com.ecommerce.enums.StatusMesa;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MesaDTO {

	
	private Long id;
	
	private String numero;

	private StatusMesa status;
	
	public MesaDTO(Mesa mesa) {
		this.id = mesa.getId();
		this.numero = mesa.getNumero();
		this.status = mesa.getStatus();
	}
	
}
