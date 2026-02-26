package com.CaseStudy2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
public class DeliveryService {
	
	@PostConstruct
	public void start() {
		System.out.println("Delivery Service Ready");
	}
	public void deliver() {
        System.out.println("Order delivered");
    }
	@PreDestroy
	public void end() {
		System.out.println("Delivery Service Closed");
	}

}
