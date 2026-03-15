package com.Online.Book.Ordering.System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Queue;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "orderQueue";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }
}