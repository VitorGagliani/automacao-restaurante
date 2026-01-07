package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.AdicionarProdutoDTO;
import com.ecommerce.dto.ClienteDTO;
import com.ecommerce.dto.CriaPedidoDTO;
import com.ecommerce.dto.ItemPedidoDTO;
import com.ecommerce.dto.MesaDTO;
import com.ecommerce.dto.PedidoDTO;
import com.ecommerce.entity.ItemPedido;
import com.ecommerce.entity.Pedido;
import com.ecommerce.service.AdicionarAoPedido;
import com.ecommerce.service.GerenciaPedidoService;
import com.ecommerce.service.ListaPedidoMenu;
import com.ecommerce.service.ListaPedidos;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private GerenciaPedidoService gerenciaPedidoService;
	
	@Autowired
	private AdicionarAoPedido adicionarAoPedido;
	
	//gerenciando pedidos
	
	@PostMapping(value = "/novo")
	public Pedido criar(@RequestBody CriaPedidoDTO pedido) {
		return gerenciaPedidoService.criar(pedido);
	}
	
	@PostMapping(value = "/adicionar")
	public ItemPedido adicionar(@RequestBody AdicionarProdutoDTO item) {
		return adicionarAoPedido.adicionar(item);
	}
	
	//ajustar o service - feito
	
	
	@PutMapping(value = "/fechar")
	public Pedido fechar (@RequestBody PedidoDTO pedido) {
		return gerenciaPedidoService.fechar(pedido.getId());
	}
	
	
	
	@PutMapping(value = "/preparar")
	public Pedido preparar(@RequestBody PedidoDTO pedido) {
		return gerenciaPedidoService.emPreparo(pedido.getId());
	}
	//-----------------------------------
	
	
	//listagens
	
	@GetMapping(value = "/listar-todos")
		public List<ListaPedidos> listar(Pedido pedido){
			return gerenciaPedidoService.listarTodos();
	}
	
	@GetMapping(value = "/listar-abertos")
	public List<ListaPedidos> listarAbertos(Pedido pedido){
		return gerenciaPedidoService.listarAbertos();
	}
	
	@GetMapping(value = "/listar-finalizados")
	public List<ListaPedidos> listarFinalizados(Pedido pedido){
		return gerenciaPedidoService.listarFinalizados();
	}
	
	//buscando por id via url
	
	@GetMapping(value = "/listar-id/{idPedido}")
	public List<ListaPedidos> listarFinalizados(@PathVariable("idPedido") Long idPedido, Pedido pedido){
		return gerenciaPedidoService.listarPorId(idPedido);
	}
	
	//to passando o id do produto via url
	
	@GetMapping(value = "/{idPedido}")
	public List<ListaPedidoMenu> listarPedidosCarrinho(@PathVariable("idPedido") Long idPedido, Pedido pedido){
		return gerenciaPedidoService.listarMenu(idPedido);
	}
	
	
}
