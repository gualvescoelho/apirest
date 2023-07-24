package com.loja.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.apirest.models.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);

}