package com.loja.apirest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.apirest.models.Produto;
import com.loja.apirest.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
    @Autowired
    private CambioService cambioService;

    public Produto salvarValor(Produto produto) {
        // Obter as taxas de câmbio atuais
        BigDecimal taxaCambioUSD = cambioService.getTaxaCambio();
        BigDecimal taxaCambioEUR = cambioService.getTaxaCambioEuro();
        BigDecimal taxaCambioGBP = cambioService.getTaxaCambioLibra();

        // Obter o preço do produto em reais (supondo que o campo 'valor' representa o preço em reais)
        BigDecimal precoEmReais = produto.getValor();

        // Converter o valor do produto para dólares, euro e libra usando as taxas de câmbio
        BigDecimal precoEmDolares = precoEmReais.multiply(taxaCambioUSD);
        BigDecimal precoEmEuros = precoEmReais.multiply(taxaCambioEUR);
        BigDecimal precoEmLibras = precoEmReais.multiply(taxaCambioGBP);

        // Definir os valores convertidos nas respectivas moedas no produto
        produto.setValor(precoEmDolares);
        produto.setValorEmEuro(precoEmEuros);
        produto.setValorEmLibra(precoEmLibras);

        // Salvar o produto no banco de dados
        return produtoRepository.save(produto);
    }

	
	public Produto salvar(Produto parametro) {
		
		return produtoRepository.save(parametro);
	}
	
	public List<Produto> pesquisar() {
		
		return produtoRepository.findAll();
	}

	public Produto buscarPorNome(String nome) {
		
		return produtoRepository.findByNome(nome);
	}
	
	public Produto alterar(Produto parametro) {
		
		return produtoRepository.save(parametro);
	}
	
	public void removerProduto(Produto parametro) {
		
		produtoRepository.delete(parametro);
	}
}
