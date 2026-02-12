package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.MesaDTO;
import com.ecommerce.entity.Mesa;
import com.ecommerce.enums.StatusMesa;
import com.ecommerce.repository.MesaRepository;

@Service
public class MesaService {
	
	@Autowired
	MesaRepository mesaRepository;
	
	public Mesa criar(MesaDTO mesaDto) {
		Mesa mesa = new Mesa();
		mesa.setNumero(mesaDto.getNumero());
		mesa.setStatus(StatusMesa.Disponivel);
		
		return mesaRepository.save(mesa);
	}
	
	public List<MesaDTO> listar(){
		return mesaRepository.listarMesas();
	}

}
