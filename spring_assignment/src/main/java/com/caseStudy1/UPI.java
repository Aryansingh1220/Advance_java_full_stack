package com.caseStudy1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UPI implements PaymentService{
	private TranactionLogger logger;
	
	public UPI(TranactionLogger logger) {
		this.logger=logger;
	}
	
	@Override
	public void processPayment(double amount) {
		logger.log("Upi Payment: "+ amount);
	}
	
	

}
