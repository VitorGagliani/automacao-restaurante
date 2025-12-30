package com.ecommerce.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NovoProdutoDTO {
	
	private String nome;
	private String descricao;
	private String imagem;
	private BigDecimal preco;
	private Long categoriaId;

}
