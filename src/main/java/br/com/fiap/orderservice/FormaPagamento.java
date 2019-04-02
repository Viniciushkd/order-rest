package br.com.fiap.orderservice;

public class FormaPagamento {

    private int idTransacao;
    private String formaPagamento;

    public FormaPagamento (int idTransacao, String formaPagamento){
        this.idTransacao = idTransacao;
        this.formaPagamento = formaPagamento;
    }

    public FormaPagamento (String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
