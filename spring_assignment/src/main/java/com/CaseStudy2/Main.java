package com.CaseStudy2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc=new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrderService orderService=ioc.getBean(OrderService.class);
		orderService.placeOrder();
	}

}
