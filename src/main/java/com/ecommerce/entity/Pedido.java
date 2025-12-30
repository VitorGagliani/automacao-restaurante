package com.ecommerce.entity;

import com.ecommerce.dto.MesaDTO;
import com.ecommerce.enums.Status;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "arqpedi")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "mesa_id", nullable = false)
	private Mesa mesa;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private Status status;
	
	@Column(nullable = false)
	private LocalDateTime dataHora;
	
}
