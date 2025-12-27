package com.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Table (name = "arqItPe")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(nullable = false)
	private Long idPedido;
	
	@Column(nullable = false)
	private Long idProduto;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private String observacao;
}
