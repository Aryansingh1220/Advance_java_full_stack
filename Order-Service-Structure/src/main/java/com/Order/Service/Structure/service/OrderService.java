package com.Order.Service.Structure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Order.Service.Structure.entity.Order;
import com.Order.Service.Structure.messaging.OrderProducer;
import com.Order.Service.Structure.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderProducer producer;

    public Order createOrder(Order order){

        order.setStatus("CREATED");

        Order saved = repository.save(order);

        producer.sendMessage(saved);

        return saved;
    }

    public List<Order> getOrders(){
        return repository.findAll();
    }
}