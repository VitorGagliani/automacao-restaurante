package com.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.dto.ItemPedidoDTO;
import com.ecommerce.entity.ItemPedido;
import com.ecommerce.service.ListaItems;
import com.ecommerce.service.ListarProdutosMenu;
import com.ecommerce.service.Pedidos;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
	
	@Query(value = """
		    select 
		        itemPedido.id as itemId,
		        itemPedido.pedido_id as pedidoId,
		        itemPedido.mesa_id as mesaPedido,
		        itemPedido.status as status,
		        itemPedido.produto_id as produtoId,
		        itemPedido.quantidade as quantidade,
		        itemPedido.observacao as observacao,
		        prod.nome as produto
		    from arq_it_pe itemPedido
		    left join arqprod prod 
		        on prod.id = itemPedido.produto_id
		    order by itemPedido.id desc
		    """, nativeQuery = true)
		List<ListaItems> listarItemsPedidos();
	
	@Query(value = """
			select
				COUNT(id) as total
			from arq_it_pe
			where status = 'EmPreparo';
			""", nativeQuery = true)
	List<Pedidos> pedidosEmPreparo();

}
