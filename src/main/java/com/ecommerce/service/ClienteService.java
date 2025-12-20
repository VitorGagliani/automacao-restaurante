package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cliente;


@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente criar(String nome, String telefone) {
		Cliente cliente = new Cliente();
		
		if(nome.isEmpty() || nome.isBlank()) {
			throw new RuntimeException("Digite um nome válido");
		}
		
		if(telefone.isEmpty() || telefone.isBlank()) {
			throw new RuntimeException("Insira um telefone válido");
		}
		
		
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		
		return clienteRepository.save(cliente);
	}
	
	

}
