package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value = "/listar")
		public List<MesaDTO> listar(){
			return mesaService.listar();
		}
	
}
