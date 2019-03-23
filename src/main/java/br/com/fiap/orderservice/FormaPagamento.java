package br.com.fiap.orderservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
