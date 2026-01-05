package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.dto.ItemPedidoDTO;
import com.ecommerce.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	 @Query(value = """
		        SELECT
		            p.id              AS pedidoId,
		            p.status          AS status,
		            p.data_hora       AS dataHora,
		            it.id             AS itemId,
		            prod.nome         AS produto,
		            it.quantidade     AS quantidade,
		            it.observacao     AS observacao
		        FROM arqpedi p
		        LEFT JOIN arq_it_pe it ON it.pedido_id = p.id
		        LEFT JOIN arqprod prod ON prod.id = it.produto_id
		        ORDER BY p.data_hora DESC
		    """, nativeQuery = true)
		    List<ItemPedidoDTO> listarPedidos();


}
