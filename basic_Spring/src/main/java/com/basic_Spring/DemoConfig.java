package com.basic_Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com")
public class DemoConfig {
	@Bean
	public static void greet() {
		Person p = new Person();
		
	}
	
}
