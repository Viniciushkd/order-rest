package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.FormaPagamento;
import br.com.fiap.orderservice.Item;
import br.com.fiap.orderservice.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class MicroservicesExemploController {

    private List<Order> orders = new ArrayList<>();

    @GetMapping("/findById/{id}")
    public Order getPedido(@PathVariable int id) {
        return orders.stream().filter(o -> o.getId() == id).findAny().orElse(null);
    }

    @PostMapping("/save")
    public ResponseEntity<Order> savePedido(@RequestBody Order order) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        order.setPrecototal(order.getPrecototal().setScale(3, BigDecimal.ROUND_HALF_EVEN));
        order.getItem().setPrecounitario(order.getItem().getPrecounitario().setScale(3, BigDecimal.ROUND_HALF_EVEN));
        orders.add(order);
        try {
            URI uri = new URI("/order/" + order.getId());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updatePedido(@PathVariable int id, @RequestBody Order order) {
        Order orderSelect = orders.stream().filter(o -> o.getId() == id).findAny().orElse(null);
        orderSelect.setEndereco(order.getEndereco());
        orderSelect.setItem(new Item(order.getItem().getDescricao(), order.getItem().getPrecounitario(), order.getItem().getQuantidade()));
        orderSelect.setFormapagamento(new FormaPagamento(order.getFormapagamento().getFormaPagamento()));
        orderSelect.setData(order.getData());
        try {
            URI uri = new URI("/update/" + order.getId());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(orderSelect, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deletePedido(@PathVariable int id) {
        Order orderSelect = orders.stream().filter(o -> o.getId() == id).findAny().orElse(null);
        orders.remove(orderSelect);
        try {
            URI uri = new URI("/delete/" + orderSelect.getId());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(orderSelect, HttpStatus.OK);
    }
}
