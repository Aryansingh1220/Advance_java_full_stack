package com.CaseStudy3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	 public static void main(String[] args) {

	        AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(AppConfig.class);

	        LoanService loanService = context.getBean(LoanService.class);
	        loanService.processLoan(300000);

	        context.close();
	    }
    
}
