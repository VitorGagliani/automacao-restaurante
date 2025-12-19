package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.UsuarioDTO;
import com.ecommerce.entity.Usuario;
import com.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDTO criar(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(usuarioDto.getSenha());
		usuario.setTipo(usuarioDto.getTipo());
		
		usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
		
	}
	
	public List<UsuarioDTO> listar(){	
		return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
	}
	
	public UsuarioDTO atualizar (UsuarioDTO usuarioDTO) {
		 Usuario usuario = new Usuario();
		 return new UsuarioDTO(usuario);
	}
	
	
	
}
