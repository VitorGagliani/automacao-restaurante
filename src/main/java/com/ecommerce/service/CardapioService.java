package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repository.ProdutoRepository;

@Service
public class CardapioService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	
}
