package com.ecommerce.service;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CriaPedidoDTO;
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
		
		Cliente cliente = clienteRepository.findById(pedidoDto.getIdCliente())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		
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
	
	
	//ajustar de acordo com chave estrangeira
	
	
	
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
	
}
