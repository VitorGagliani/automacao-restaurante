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
	
	@Column(nullable = false)
	private Long idMesa;
	
	@Column(nullable = false)
	private Long idCliente;
	
	@Column(nullable = false)
	private String clienteNome;
	
	@Column(nullable = false)
	private String clienteTelefone;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private Status status;
	
	@Column(nullable = false)
	private LocalDateTime dataHora;
	
}
