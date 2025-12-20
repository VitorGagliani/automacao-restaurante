package com.ecommerce.dto;
import java.math.BigDecimal;
import com.ecommerce.entity.Produto;

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
	
	private CategoriaDTO categoria;

	private String imagem;
	
	public ProdutoDTO (Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.categoria = new CategoriaDTO(produto.getCategoria());
		this.imagem = produto.getImagem();
	}


}
