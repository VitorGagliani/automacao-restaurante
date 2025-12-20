package com.ecommerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "arqprod")
@Setter
@Getter
@EqualsAndHashCode
public class Produto{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false)
		private String nome;

		@Column(nullable = false)
		private String descricao;
		
		@Column(nullable = false)
		private BigDecimal preco;
		
		@JoinColumn(name = "cat_id", nullable = false)
		@ManyToOne
		private Categoria categoria;
		
		@Column(nullable = false)
		private String imagem;
		
}


