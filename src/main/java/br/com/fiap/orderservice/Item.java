package br.com.fiap.orderservice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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

}
