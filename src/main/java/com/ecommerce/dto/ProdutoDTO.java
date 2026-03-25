package com.ecommerce.dto;
import java.math.BigDecimal;
import com.ecommerce.entity.Produto;
import com.ecommerce.enums.ProdutoStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO{
	private Long id;
		
	private String nome;

	private String descricao;

	private BigDecimal preco;
	
	private Long categoriaId;

	private String imagem;
	
	private ProdutoStatus status;
	
	public ProdutoDTO (Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.categoriaId = produto.getCategoria().getId();
		this.imagem = produto.getImagem();
		this.status = produto.getStatus();
	}


}
