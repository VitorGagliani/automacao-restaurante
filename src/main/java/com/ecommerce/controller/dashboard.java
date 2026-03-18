package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.service.Faturamento;
import com.ecommerce.service.GerenciaPedidoService;
import com.ecommerce.service.Pedidos;
import com.ecommerce.service.ProdutoMaisPedido;
import com.ecommerce.service.ProdutoService;


@RestController
@RequestMapping(value = "/dashboard")
public class dashboard {
	
	@Autowired
	ProdutoService produto;
	
	@Autowired
	GerenciaPedidoService pedido;
	
	@GetMapping(value = "/produtoPedido")
	public List<ProdutoMaisPedido> produtoMaisPedido(){
		return  produto.produtoMaisPedido();
	}
	
	@GetMapping(value = "/totalPedidosMes")
	public List<Pedidos> totalPedidosMes(){
		return pedido.totalPedidos();
	}

	@GetMapping(value = "/totalPedidosHoje")
	public List<Pedidos> totalPedidosHoje(){
		return pedido.totalPedidosHoje();
	}
	
	@GetMapping(value = "/pedidosEmPreparo")
	public List<Pedidos> pedidosEmPreparo(){
		return pedido.pedidosEmPreparo();
	}
	
	@GetMapping(value = "/faturamentoMes")
	public List<Faturamento> faturamentoMes(){
		return pedido.totalMes();
	}
	
	@GetMapping(value = "/faturamentoDia")
	public List<Faturamento> faturamentoDia(){
		return pedido.totalDia();
	}
	
}
