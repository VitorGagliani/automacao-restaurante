package com.ecommerce.dto;
import java.math.BigDecimal;
import com.ecommerce.entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProdutoDTO{
	private Long id;
		
	private String nome;

	private String descricao;

	private BigDecimal preco;
	
	private Categoria categoria;

	private String imagem;


}
