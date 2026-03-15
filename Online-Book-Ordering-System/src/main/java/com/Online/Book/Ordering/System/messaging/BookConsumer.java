package com.Online.Book.Ordering.System.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online.Book.Ordering.System.service.BookService;

@Service
public class BookConsumer {

    @Autowired
    private BookService bookService;

    @RabbitListener(queues = "orderQueue")
    public void receiveOrder(OrderMessage message){

        bookService.reduceStock(message.getBookId(), message.getQuantity());

        System.out.println("Stock updated for book: " + message.getBookId());
    }
}