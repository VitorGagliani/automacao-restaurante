package com.ecommerce.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Mesa;
import com.ecommerce.entity.Pedido;
import com.ecommerce.enums.Status;
import com.ecommerce.enums.StatusMesa;
import com.ecommerce.repository.MesaRepository;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.repository.ProdutoRepository;

@Service
public class CriarPedidoService {

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
	
	public Pedido criar(Long idMesa, Long idCliente, String clienteNome, String clienteTelefone) {
		
		Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
		Cliente cliente = clienteRepository.findById(idCliente).orElseGet(() ->
				clienteService.criar(clienteNome, clienteTelefone)
				);
		
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
	
}
