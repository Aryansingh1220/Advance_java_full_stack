package com.basic_Spring.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.basic_Spring.DemoConfig;

@Component
public class User {
	
	@Autowired
	@Qualifier("creditCard")
	private Payment payment;
	
	public void display() {
		payment.send();
	}
	
	public static void main(String[] args) {
		ApplicationContext ioc=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		User u=ioc.getBean(User.class);
		System.out.println(u);
		
		u.display();
	}

}
