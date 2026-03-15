package com.Order.Service.Structure.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Order.Service.Structure.entity.Order;

@Service
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Order order){

        OrderMessage message = new OrderMessage();

        message.setBookId(order.getBookId());
        message.setQuantity(order.getQuantity());

        rabbitTemplate.convertAndSend("orderQueue", message);
    }
}