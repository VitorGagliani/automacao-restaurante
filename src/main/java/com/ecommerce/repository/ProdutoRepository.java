package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.entity.Produto;
import com.ecommerce.service.ListarProdutosMenu;

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
	

}
