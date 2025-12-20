package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	

}
