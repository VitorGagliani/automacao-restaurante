package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ClienteDTO;
import com.ecommerce.dto.MesaDTO;
import com.ecommerce.dto.PedidoDTO;
import com.ecommerce.entity.Pedido;
import com.ecommerce.service.GerenciaPedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private GerenciaPedidoService gerenciaPedidoService;
	
	@PostMapping(value = "/novo")
	public Pedido criar(@RequestBody PedidoDTO pedido) {
		return gerenciaPedidoService.criar(pedido.getIdMesa(),
				pedido.getClienteNome(),
				pedido.getClienteTelefone());
	}
	
	
	@PutMapping(value = "/fechar")
	public Pedido fechar (@RequestBody PedidoDTO pedido) {
		return gerenciaPedidoService.fechar(pedido.getId());
	}
	
	@PutMapping(value = "/preparar")
	public Pedido preparar(@RequestBody PedidoDTO pedido) {
		return gerenciaPedidoService.emPreparo(pedido.getId());
	}
}
