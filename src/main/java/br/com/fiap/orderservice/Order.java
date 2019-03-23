package br.com.fiap.orderservice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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

}
