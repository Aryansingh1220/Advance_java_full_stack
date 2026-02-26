package com.basic_Spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("10")
	private int id;
	@Value("Miller")
	private String name;
	@Value("10000")
	private int salary;
//	
//	@Autowired
//	private 
	
	

}
