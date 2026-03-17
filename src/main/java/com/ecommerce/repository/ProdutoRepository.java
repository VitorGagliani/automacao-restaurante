package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.entity.Produto;
import com.ecommerce.service.ListarProdutosMenu;
import com.ecommerce.service.ProdutoMaisPedido;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = """
			select
			id,
			imagem,
			nome,
			preco,
			descricao
		from arqprod
		where cat_id = ?1;"""
			, nativeQuery = true)
	List<ListarProdutosMenu> listarProdutos(Long idCategoria);
	
	@Query(value = """
			select
			id,
			imagem,
			nome,
			preco,
			descricao
		from arqprod;"""
			, nativeQuery = true)
	List<ListarProdutosMenu> listarProdutosTodos();
	
//produto mais pedido	
	
	@Query(value = """
			SELECT
			 produto.id, nome, SUM(quantidade) AS total
			FROM arq_it_pe
			left join arqprod produto on produto_id = produto.id
			GROUP BY produto.id
			ORDER BY total desc
				limit 1;
			""", nativeQuery = true)
	List<ProdutoMaisPedido> produtoMaisPedido();

}
