package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.MesaDTO;
import com.ecommerce.entity.Mesa;
import com.ecommerce.service.MesaService;

@RestController
@RequestMapping(value = "/mesas")
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@PostMapping(value = "/nova")
	public Mesa criar(@RequestBody MesaDTO mesaDto) {
		return mesaService.criar(mesaDto);
	}
	
	@PutMapping(value = "/editar")
	public Mesa editar(@RequestBody MesaDTO mesa) {
		return mesaService.editar(mesa);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
	    try {
	        mesaService.deletar(id);
	        return ResponseEntity.noContent().build();
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
	@GetMapping(value = "/listar")
		public List<MesaDTO> listar(){
			return mesaService.listar();
		}
	
}
