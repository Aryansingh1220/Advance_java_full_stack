package com.basics_of_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ioc=new ClassPathXmlApplicationContext("config.xml");
		
		Person person=ioc.getBean("person",Person.class);
		
		System.out.println(person);
		person.message();
		
		Employee employee=ioc.getBean("employee",Employee.class);
		
//		employee.setId(100);
//		employee.setName("Aryan");
//		employee.setSalary(100000);
		
		System.out.println(employee);
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
	}

}
