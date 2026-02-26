package com.basic_Spring.prac;

import org.springframework.context.annotation.Primary; 
import org.springframework.stereotype.Component;

public interface Payment {
	public void send();

}

@Component
@Primary
class UPI implements Payment{
	@Override
	public void send() {
		System.out.println("UPI");
	}
	
}


@Component
class CreditCard implements Payment{
	@Override
	public void send() {
		System.out.println("Credit card");
		
	}
}
