package com.caseStudy1;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCard implements PaymentService{
	private TranactionLogger logger;
	public CreditCard(TranactionLogger logger) {
		this.logger=logger;
	}
	
	
	@Override
	public void processPayment(double amount) {
		logger.log("Credit card Payment: "+amount);
		
	}
	
	

}
