package com.loja.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{

	private static final long serialVersionUID = -7452954603443054695L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private int quantidade;
	
	private BigDecimal valor;
	
	private BigDecimal valorEmEuro;
    
    private BigDecimal valorEmLibra;

	public Produto() {
		super();
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Produto(String nome, int quantidade, BigDecimal valor) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getValorEmEuro() {
		return valorEmEuro;
	}

	public void setValorEmEuro(BigDecimal valorEmEuro) {
		this.valorEmEuro = valorEmEuro;
	}

	public BigDecimal getValorEmLibra() {
		return valorEmLibra;
	}

	public void setValorEmLibra(BigDecimal valorEmLibra) {
		this.valorEmLibra = valorEmLibra;
	}
	
}
