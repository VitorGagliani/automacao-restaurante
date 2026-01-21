package com.ecommerce.dto;

import com.ecommerce.entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO{
		
	private Long id;

	private String nome;
	
	public CategoriaDTO (Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}


}
