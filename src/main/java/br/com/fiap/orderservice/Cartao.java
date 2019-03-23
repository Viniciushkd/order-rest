package br.com.fiap.orderservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cartao {

    private String numero;
    private String validade;
    private String bandeira;
}
