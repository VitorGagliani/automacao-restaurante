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
import lombok.Setter;

@Entity
@Table(name = "arqprod")
@Setter
@EqualsAndHashCode
public class Produto{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id;
		
		@Column(nullable = false)
		String nome;

		@Column(nullable = false)
		String descricao;
		
		@Column(nullable = false)
		BigDecimal preco;
		
		@JoinColumn(name = "cat_id", nullable = false)
		@ManyToOne
		Categoria categoria;
		
		@Column(nullable = false)
		String imagem;
		
}


