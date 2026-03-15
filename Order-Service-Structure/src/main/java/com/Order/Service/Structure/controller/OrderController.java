package com.Order.Service.Structure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Order.Service.Structure.entity.Order;
import com.Order.Service.Structure.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return service.createOrder(order);
    }

    @GetMapping
    public List<Order> getOrders(){
        return service.getOrders();
    }
}