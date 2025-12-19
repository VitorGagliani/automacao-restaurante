package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
