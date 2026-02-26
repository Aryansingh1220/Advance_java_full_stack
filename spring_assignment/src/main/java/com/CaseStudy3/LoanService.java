package com.CaseStudy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {
	
	private LoanValidator validator;
	private AuditService auditService;
	
	public LoanService(@Qualifier("incomeValidator")LoanValidator validator) {
		this.validator=validator;
	}
	
	@Autowired
	public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void processLoan(double amount) {
        if (validator.validateLoan(amount)) {
            System.out.println("Loan Approved: " + amount);
            auditService.audit("Loan approved");
        } else {
            System.out.println("Loan Rejected");
        }
    }

}
