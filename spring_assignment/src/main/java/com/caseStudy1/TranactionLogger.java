package com.caseStudy1;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component
public class TranactionLogger {

	
	@PostConstruct
    public void init() {
        System.out.println("Logger initialized");
    }

    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger destroyed");
    }

}
