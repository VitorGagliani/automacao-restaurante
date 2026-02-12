package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.dto.MesaDTO;
import com.ecommerce.entity.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long>{
	
	@Query("""
		    SELECT
		    new com.ecommerce.dto.MesaDTO(m.id, m.numero, m.status)
		    FROM Mesa m
		""")
		List<MesaDTO> listarMesas();


}
