	package com.ecommerce.repository;
	
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
		
		@Query(value = """
				select 
	    id, 
	    status, 
	    mesa_id as mesa, 
	    data_hora as hora_Pedido
	    from arqpedi
	    where status <> 'Finalizado'
		order by id desc;		
				""", nativeQuery = true)
		List<GridCozinha> listarGridCozinha();
		
		@Query(value = """
				select
        item.id as item_codigo,
        prod.nome as produto,
        item.quantidade as quantidade_produto,
        item.observacao as observacao_produto
        from arqpedi pedido
        left join arq_it_pe item on item.pedido_id = pedido.id
        left join arqprod prod on prod.id = item.produto_id
        where pedido.id = ?1;
				""", nativeQuery = true)
		List<DialogGrid> dialogProduto(Long id);
	
	}
	
	
	
