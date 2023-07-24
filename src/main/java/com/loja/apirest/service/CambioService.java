package com.loja.apirest.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loja.apirest.models.Cambio;
//import com.loja.apirest.repository.CambioRepository;

@Service
public class CambioService {

    // URL da sua API de câmbio
    private static final String CAMBIO_API_URL = "http://localhost:8009/cambio-service/";

    public BigDecimal getTaxaCambio() {
        // Realize uma requisição HTTP para a API de câmbio para obter a taxa de câmbio atual entre reais e dólares
        RestTemplate restTemplate = new RestTemplate();
        Cambio cambio = restTemplate.getForObject(CAMBIO_API_URL + "1/USD/BRL", Cambio.class);
        return cambio.getConversionFactor();
    }

    public BigDecimal getTaxaCambioEuro() {
        // Realize uma requisição HTTP para a API de câmbio para obter a taxa de câmbio atual entre reais e euros
        RestTemplate restTemplate = new RestTemplate();
        Cambio cambio = restTemplate.getForObject(CAMBIO_API_URL + "1/USD/EUR", Cambio.class);
        return cambio.getConversionFactor();
    }

    public BigDecimal getTaxaCambioLibra() {
        // Realize uma requisição HTTP para a API de câmbio para obter a taxa de câmbio atual entre reais e libras
        RestTemplate restTemplate = new RestTemplate();
        Cambio cambio = restTemplate.getForObject(CAMBIO_API_URL + "1/USD/GBP", Cambio.class);
        return cambio.getConversionFactor();
    }
}
