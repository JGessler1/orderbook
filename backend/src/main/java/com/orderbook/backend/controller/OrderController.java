package com.orderbook.backend.controller;

import com.orderbook.backend.engine.OrderBook;
import com.orderbook.backend.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderBook orderBook = new OrderBook();

    @PostMapping
    public String addOrder(@RequestBody Order order) {
        orderBook.addOrder(order);
        return "Order Added";
    }

    @GetMapping
    public OrderBook getOrderBook() {
        return orderBook;
    }

    @GetMapping("/trades")
    public Object getTrades() {
        return orderBook.getTrades();
    }
    
}
