package com.ecommerce.service;

import java.util.List;
import java.io.Console;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CriaPedidoDTO;
import com.ecommerce.dto.ItemPedidoDTO;
import com.ecommerce.dto.ListaPedidoDTO;
import com.ecommerce.dto.PedidoDTO;
import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Mesa;
import com.ecommerce.entity.Pedido;
import com.ecommerce.enums.Status;
import com.ecommerce.enums.StatusMesa;
import com.ecommerce.repository.ClienteRepository;
import com.ecommerce.repository.MesaRepository;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.repository.ProdutoRepository;

@Service
public class GerenciaPedidoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	MesaRepository mesaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public Pedido criar(CriaPedidoDTO pedidoDto ) {
		
		Mesa mesa = mesaRepository.findById(pedidoDto.getIdMesa())
				.orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
		
	//	Cliente cliente = clienteRepository.findById(pedidoDto.getIdCliente())
			//	.orElse(clienteService.criar(pedidoDto.getIdCliente()));
		
		Cliente cliente = clienteRepository.findByTelefone(pedidoDto.getTelefone())
				.orElseGet(() ->clienteService.criar(pedidoDto.getClienteNome(), pedidoDto.getTelefone()));

		
		
		if (mesa.getStatus() != StatusMesa.Disponivel) {
			throw new RuntimeException("Mesa não dispoível no momento");
		}
		
		
		Pedido pedido = new Pedido();
		pedido.setMesa(mesa);
		pedido.setCliente(cliente);
		pedido.setDataHora(LocalDateTime.now());
		pedido.setStatus(Status.Aberto);
		
		mesa.setStatus(StatusMesa.Indisponivel);
		
		return pedidoRepository.save(pedido);
		
		
	}
	
	
	//ajustado para pegar o ID do pedido
	
	
	
	public Pedido fechar(Long id) {
		
		
		Pedido pedido = pedidoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
		
		if(pedido.getStatus() == Status.Finalizado) {
			throw new RuntimeException("Pedido já foi finalizado");
		}
		
		
		pedido.setStatus(Status.Finalizado);
		
		
	
		
		Mesa mesa = pedido.getMesa();
		mesa.setStatus(StatusMesa.Disponivel);
		
		return pedidoRepository.save(pedido);
		
	}
	
	
	
	public Pedido emPreparo(Long id) {
		
		
		Pedido pedido = pedidoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
		
		if(pedido.getStatus() == Status.Finalizado) {
			throw new RuntimeException("Pedido já foi finalizado");
		}
		
		if(pedido.getStatus() == Status.EmPreparo) {
			throw new RuntimeException("Pedido já está sendo preparado");
		}
		
		pedido.setStatus(Status.EmPreparo);
		
		return pedidoRepository.save(pedido);
		
	}
	
	//commit Ajuste query listar pedidos
	
	
	public List<ListaPedidos> listarTodos() {
		return pedidoRepository.listarTodosPedidos().stream().map(pedido -> new ListaPedidos(
	            pedido.pedidoId(),
	            pedido.status(),
	            pedido.itemId(),
	            pedido.produto(),
	            pedido.quantidade(),
	            pedido.observacao()
				)).toList();
	}
	
	
	//commit Ajuste query listar pedidos
	
	public List<ListaPedidos> listarAbertos(){
		return pedidoRepository.listarPedidosAbertos().stream().map(pedido -> new ListaPedidos(
				pedido.pedidoId(),
				pedido.status(),
				pedido.itemId(),
				pedido.produto(),
				pedido.quantidade(),
				pedido.observacao()
				)).toList();
	}
	
	//commit Adicionado query de listar pedidos finalizados
	
	public List<ListaPedidos> listarFinalizados(){
		return pedidoRepository.listarPedidosFinalizados().stream().map(pedido -> new ListaPedidos(
				pedido.pedidoId(),
				pedido.status(),
				pedido.itemId(),
				pedido.produto(),
				pedido.quantidade(),
				pedido.observacao()
				)).toList();
	}
	
	
	//chamando query para buscar o pedido por id
	
	public List<ListaPedidos> listarPorId(Long idPedido){
		return pedidoRepository.listarPedidosPorId(idPedido).stream().map(pedido -> new ListaPedidos(
				pedido.pedidoId(),
				pedido.status(),
				pedido.itemId(),
				pedido.produto(),
				pedido.quantidade(),
				pedido.observacao()
				)).toList();
	}
	
	//query planejada para listar o pedido no menu-carrinho
	
	public List<ListaPedidoMenu> listarMenu(Long idPedido){
		return pedidoRepository.listarPedidosMenu(idPedido).stream().map(pedido -> new ListaPedidoMenu(
				pedido.pedidoId(),
				pedido.nome(),
				pedido.produtoImagem(),
				pedido.preco(),
				pedido.quantidade(),
				pedido.observacao()
				)).toList();
	}
	
	public List<GridCozinha> listarGridCozinha(){
		return pedidoRepository.listarGridCozinha().stream().map(pedido -> new GridCozinha(
				pedido.id(),
				pedido.status(),
				pedido.mesa(),
				pedido.hora_pedido()
				)).toList();
	}
	
	
//Dialog do pedido cozinha
	
	public List<DialogGrid> dialogCozinha(Long id){
		return pedidoRepository.dialogProdutoCozinha(id).stream().map(pedido -> new DialogGrid(
				pedido.pedido_id(),
				pedido.status(),
				pedido.produto(),
				pedido.quantidade_produto(),
				pedido.observacao_produto(),
				pedido.data()
				)).toList();
	}
	
}
