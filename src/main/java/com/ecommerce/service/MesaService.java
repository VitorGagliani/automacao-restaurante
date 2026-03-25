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
	
	public Mesa editar(MesaDTO mesaDto) {
		Mesa mesa = mesaRepository.findById(mesaDto.getId()).orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
		mesa.setNumero(mesaDto.getNumero());
		return mesaRepository.save(mesa);
	}
	
	public void deletar(Long id) {
	    mesaRepository.deleteById(id);
	}
	
	public List<MesaDTO> listar(){
		return mesaRepository.listarMesas();
	}

}
