package com.loja.apirest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.apirest.models.Produto;
import com.loja.apirest.service.CambioService;
import com.loja.apirest.service.ProdutoService;

@RestController
@RequestMapping(value="/loja")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	CambioService cambioService;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		
		return produtoService.pesquisar();
	}
	
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
	    // Obter as taxas de câmbio atuais
	    BigDecimal taxaCambioUSD = cambioService.getTaxaCambio();
	    BigDecimal taxaCambioEUR = cambioService.getTaxaCambioEuro();
	    BigDecimal taxaCambioGBP = cambioService.getTaxaCambioLibra();

	    // Converter o valor do produto para dólares usando a taxa de câmbio
	    BigDecimal valorEmDolar = produto.getValor().multiply(taxaCambioUSD);
	    // Converter o valor do produto para Euro usando a taxa de câmbio
	    BigDecimal valorEmEuro = produto.getValor().multiply(taxaCambioEUR);
	    // Converter o valor do produto para Libra usando a taxa de câmbio
	    BigDecimal valorEmLibra = produto.getValor().multiply(taxaCambioGBP);

	    // Definir os valores convertidos nas respectivas moedas no produto
	    produto.setValor(valorEmDolar);
	    produto.setValorEmEuro(valorEmEuro);
	    produto.setValorEmLibra(valorEmLibra);

	    // Salvar o produto no banco de dados
	    return produtoService.salvar(produto);
	}

	@GetMapping("/produto/{nome}")
	public Produto listaProdutosByNome(@PathVariable(value="nome") String nome){
		
		return produtoService.buscarPorNome(nome);
	}
	
	/*@PostMapping("/produto")
	public Produto listaProdutosByNome(@RequestBody Produto produto){
		
		return produtoService.salvar(produto);
	}*/
	
	@DeleteMapping("/produto")
	public void removerProduto(@RequestBody Produto produto){
		
		produtoService.removerProduto(produto);
	}
	
	@PutMapping("/produto")
	public void alterarProduto(@RequestBody Produto produto){
		
		produtoService.alterar(produto);
	}
	
}
