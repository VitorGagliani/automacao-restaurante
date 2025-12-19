package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
