package br.com.fiap.orderservice;

import java.math.BigDecimal;

public class Order {

    private int id;
    private String nome;
    private String endereco;
    private Item item;
    private BigDecimal precototal;
    private FormaPagamento formapagamento;
    private Cartao cartao;
    private String data;
    private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public BigDecimal getPrecototal() {
		return precototal;
	}
	public void setPrecototal(BigDecimal precototal) {
		this.precototal = precototal;
	}
	public FormaPagamento getFormapagamento() {
		return formapagamento;
	}
	public void setFormapagamento(FormaPagamento formapagamento) {
		this.formapagamento = formapagamento;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
