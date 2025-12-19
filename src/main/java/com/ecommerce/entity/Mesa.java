package com.ecommerce.entity;


import com.ecommerce.enums.StatusMesa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "arqmesa")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;
	
	@Column(nullable = false)
	String numero;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	StatusMesa status;
	
	
	

}
