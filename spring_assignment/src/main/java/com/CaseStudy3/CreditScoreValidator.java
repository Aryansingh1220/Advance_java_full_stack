package com.CaseStudy3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator{
	
	@Override
    public boolean validateLoan(double amount) {
        System.out.println("Credit Score Validation");
        return true;
    }

}
