package com.ecommerce.dto;



import com.ecommerce.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClienteDTO {

	Long id;
	
	String nome;

	String telefone;
	
	public ClienteDTO (Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}
}
