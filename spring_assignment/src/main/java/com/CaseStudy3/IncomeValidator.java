package com.CaseStudy3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator{
	
	@Override
    public boolean validateLoan(double amount) {
        System.out.println("Income Validation");
        return amount <= 500000;
    }

}
