package br.com.fiap.orderservice;

import java.math.BigDecimal;

public class Item {

    private int id;
    private String descricao;
    private BigDecimal precounitario;
    private int quantidade;

    public Item(String descricao, BigDecimal precounitario, int quantidade){
        this.descricao = descricao;
        this.precounitario = precounitario;
        this.quantidade = quantidade;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecounitario() {
		return precounitario;
	}

	public void setPrecounitario(BigDecimal precounitario) {
		this.precounitario = precounitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
