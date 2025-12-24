package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.PedidoDTO;
import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Mesa;
import com.ecommerce.entity.Pedido;
import com.ecommerce.enums.Status;
import com.ecommerce.enums.StatusMesa;
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
	
	public Pedido criar(Long idMesa, String clienteNome,
			String clienteTelefone) {
		
		Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
		
		Cliente cliente = clienteRepository.findByTelefone(clienteTelefone)
			    .orElseGet(() -> clienteService.criar(clienteNome, clienteTelefone));

		
		if (mesa.getStatus() != StatusMesa.Disponivel) {
			throw new RuntimeException("Mesa não dispoível no momento");
		}
		
		Pedido pedido = new Pedido();
		pedido.setIdMesa(idMesa);
		pedido.setIdCliente(cliente.getId());
		pedido.setClienteNome(clienteNome);
		pedido.setClienteTelefone(clienteTelefone);
		pedido.setDataHora(LocalDateTime.now());
		pedido.setStatus(Status.Aberto);
		
		mesa.setStatus(StatusMesa.Indisponivel);
		
		return pedidoRepository.save(pedido);
		
		
	}
	
	public Pedido fechar(Long id) {
		
		
		Pedido pedido = pedidoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
		
		if(pedido.getStatus() == Status.Finalizado) {
			throw new RuntimeException("Pedido já foi finalizado");
		}
		
		
		pedido.setStatus(Status.Finalizado);
		Long mesaPedido = pedido.getIdMesa();
		
		Mesa mesa = mesaRepository.findById(mesaPedido).orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
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
	
}
