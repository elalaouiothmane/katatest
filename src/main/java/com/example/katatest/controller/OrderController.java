package com.example.katatest.controller;

import com.example.katatest.model.Order;
import com.example.katatest.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Mono<Order>> createOrder(@RequestBody Order order){
        Mono<Order> orderCreated =  orderService.createOrder(order);
        if(orderCreated !=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(orderCreated);

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(orderCreated);
    }
}
