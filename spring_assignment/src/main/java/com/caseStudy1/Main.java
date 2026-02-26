package com.caseStudy1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ioc=new AnnotationConfigApplicationContext(AppConfig.class);

		PaymentProcessor processor=ioc.getBean(PaymentProcessor.class);
		processor.pay(6000);
	}

}
