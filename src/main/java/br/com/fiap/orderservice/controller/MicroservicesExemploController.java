package br.com.fiap.orderservice.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.orderservice.FormaPagamento;
import br.com.fiap.orderservice.Item;
import br.com.fiap.orderservice.Order;
import br.com.fiap.orderservice.handler.ExceptionReponse;
import br.com.fiap.orderservice.handler.PedidoNotFoundException;
import br.com.fiap.orderservice.handler.RestResponseEntityExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order")
public class MicroservicesExemploController {

    private List<Order> orders = new ArrayList<>();
    
    @GetMapping("/findById/{id}")
    public Order getPedido(@PathVariable int id) {
        Order pedido =  orders.stream().filter(o -> o.getId() == id).findAny().orElse(null);
        if(pedido == null) {
        	throw new PedidoNotFoundException("id:" + id);
        } else {
        	return pedido;
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePedido(@RequestBody Order order) {
        order.setPrecototal(order.getPrecototal().setScale(3, BigDecimal.ROUND_HALF_EVEN));
        order.getItem().setPrecounitario(order.getItem().getPrecounitario().setScale(3, BigDecimal.ROUND_HALF_EVEN));
        orders.add(order);
        try {
            URI uri = new URI("/order/" + order.getId());
            return new ResponseEntity<>(uri, HttpStatus.OK);
        } catch (Exception e){
        	return new RestResponseEntityExceptionHandler().handlePedidoRespondeEntity(new ExceptionReponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePedido(@PathVariable int id, @RequestBody Order order) {
        Order orderSelect = orders.stream().filter(o -> o.getId() == id).findAny().orElse(null);
        orderSelect.setEndereco(order.getEndereco());
        orderSelect.setItem(new Item(order.getItem().getDescricao(), order.getItem().getPrecounitario(), order.getItem().getQuantidade()));
        orderSelect.setFormapagamento(new FormaPagamento(order.getFormapagamento().getFormaPagamento()));
        orderSelect.setData(order.getData());
        try {
            URI uri = new URI("/update/" + order.getId());
            return new ResponseEntity<>(uri, HttpStatus.OK);
        } catch (Exception e){
        	return new RestResponseEntityExceptionHandler().handlePedidoRespondeEntity(new ExceptionReponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable int id) {
        Order orderSelect = orders.stream().filter(o -> o.getId() == id).findAny().orElse(null);
        orders.remove(orderSelect);
        try {
            URI uri = new URI("/delete/" + orderSelect.getId());
            return new ResponseEntity<>(uri, HttpStatus.OK);
        } catch (Exception e){
            return new RestResponseEntityExceptionHandler().handlePedidoRespondeEntity(new ExceptionReponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }
}
