package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.dto.ItemPedidoDTO;
import com.ecommerce.entity.Pedido;
import com.ecommerce.service.ListaPedidoMenu;
import com.ecommerce.service.ListaPedidos;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Query(value = """
		    SELECT
		        p.id              AS pedidoId,
		        p.status          AS status,
		        it.id             AS itemId,
		        prod.nome         AS produto,
		        it.quantidade     AS quantidade,
		        it.observacao     AS observacao
		    FROM arqpedi p
		    LEFT JOIN arq_it_pe it ON it.pedido_id = p.id
		    LEFT JOIN arqprod prod ON prod.id = it.produto_id
		    ORDER BY p.id DESC
		""", nativeQuery = true)
		    List<ListaPedidos> listarTodosPedidos();
	
	@Query(value = """
		    SELECT
		        p.id              AS pedidoId,
		        p.status          AS status,
		        it.id             AS itemId,
		        prod.nome         AS produto,
		        it.quantidade     AS quantidade,
		        it.observacao     AS observacao
		    FROM arqpedi p
		    LEFT JOIN arq_it_pe it ON it.pedido_id = p.id
		    LEFT JOIN arqprod prod ON prod.id = it.produto_id
		    where p.status = 'Aberto'
		    ORDER BY p.id DESC
		""", nativeQuery = true)
		    List<ListaPedidos> listarPedidosAbertos();
	
	@Query(value = """
			 SELECT
		        p.id              AS pedidoId,
		        p.status          AS status,
		        it.id             AS itemId,
		        prod.nome         AS produto,
		        it.quantidade     AS quantidade,
		        it.observacao     AS observacao
		    FROM arqpedi p
		    LEFT JOIN arq_it_pe it ON it.pedido_id = p.id
		    LEFT JOIN arqprod prod ON prod.id = it.produto_id
		    where p.status = 'Finalizado'
		    ORDER BY p.id DESC
		""", nativeQuery = true)
		    List<ListaPedidos> listarPedidosFinalizados();
	
	@Query(value = """
			 SELECT
		        p.id              AS pedidoId,
		        p.status          AS status,
		        it.id             AS itemId,
		        prod.nome         AS produto,
		        it.quantidade     AS quantidade,
		        it.observacao     AS observacao
		    FROM arqpedi p
		    LEFT JOIN arq_it_pe it ON it.pedido_id = p.id
		    LEFT JOIN arqprod prod ON prod.id = it.produto_id
		    where p.id = ?1
		    ORDER BY prod.nome DESC
		""", nativeQuery = true)
		    List<ListaPedidos> listarPedidosPorId(Long idPedido);
	
	@Query(value = """
			 select 
 	p.id as pedidoID,
 	prod.nome as produto,
 	prod.imagem as produtoImagem,
 	it.quantidade as quantidade,
 	it.observacao as observacao
 	from arqpedi p
 	left join arq_it_pe it on it.pedido_id = p.id
 	left join arqprod prod on prod.id = it.produto_id
 	where p.id = ?1 and p.status = 'Aberto'
 	order by it.quantidade desc;
			""", nativeQuery = true)
	List<ListaPedidoMenu> listarPedidosMenu(Long idPedido);

}
