package com.CaseStudy3;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class AuditService {
	
	@PostConstruct
	public void start() {
		System.out.print("Start.....");
	}
	
	public void audit(String msg) {
        System.out.println("AUDIT: " + msg);
    }
	
	
	@PreDestroy
	public void end() {
		System.out.println("End......");
	}

}
