package com.ecommerce.dto;

import com.ecommerce.entity.Usuario;
import com.ecommerce.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDTO{
		private Long id;
		
		private String nome;
	
		private String email;

		private String senha;
	
		private Tipo tipo;
		
		public UsuarioDTO(Usuario usuario) {
		    this.id = usuario.getId();
		    this.nome = usuario.getNome();
		    this.email = usuario.getEmail();
		    this.tipo = usuario.getTipo();
		}

		 

}
