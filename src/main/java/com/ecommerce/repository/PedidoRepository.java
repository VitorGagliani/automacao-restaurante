	package com.ecommerce.repository;
	
	import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	
	import com.ecommerce.dto.ItemPedidoDTO;
	import com.ecommerce.dto.PedidoDTO;
	import com.ecommerce.entity.Pedido;
import com.ecommerce.service.DialogGrid;
import com.ecommerce.service.GridCozinha;
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
		
		
		
		//Pedido no carrinho
		
		@Query(value = """
				 select 
	 	p.id as pedidoID,
	 	prod.nome as produto,
	 	prod.imagem as produtoImagem,
	 	prod.preco as produtoPreco,
	 	it.quantidade as quantidade,
	 	it.observacao as observacao
	 	from arqpedi p
	 	left join arq_it_pe it on it.pedido_id = p.id
	 	left join arqprod prod on prod.id = it.produto_id
	 	where p.id = ?1
	 	order by it.quantidade desc;
				""", nativeQuery = true)
		List<ListaPedidoMenu> listarPedidosMenu(Long idPedido);
		
		//Primeira grid da cozinha
		
		//nao me pergunte o que é isso
		
		@Query(value = """
			    select 
			        id, 
			        status, 
			        mesa_id as mesa, 
			        data_hora as data_pedido
			    from arqpedi
			    where 
			        (:status is null or status = :status)
			        and (:mesa is null or mesa_id = :mesa)
			        and data_hora >= coalesce(:dataInicio, data_hora)
			        and data_hora <= coalesce(:dataFim, data_hora)
			    order by id desc
			    """, nativeQuery = true)
			List<GridCozinha> listarGridCozinha(
			        @Param("status") String status,
			        @Param("mesa") Long mesa,
			        @Param("dataInicio") LocalDateTime dataInicio,
			        @Param("dataFim") LocalDateTime dataFim
			);
		@Query(value = """
				select
		pedido.id as numero_pedido,
		pedido.status as status,
		prod.nome as produto,
		item.quantidade as quantidade_produto,
		item.observacao as observacao_produto,
		pedido.data_hora as data
		from arqpedi pedido
		left join arq_it_pe item on item.pedido_id = pedido.id
		left join arqprod prod on prod.id = item.produto_id
		where pedido.id = ?1;
				""", nativeQuery = true)
		List<DialogGrid> dialogProdutoCozinha(Long id);
	
	}
	
	
	
