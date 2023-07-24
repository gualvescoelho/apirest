package com.loja.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findByNome(String name);
	
}
