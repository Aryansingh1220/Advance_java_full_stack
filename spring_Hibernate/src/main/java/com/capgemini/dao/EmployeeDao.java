package com.capgemini.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JpaUnit;



//@ComponentScan
@Repository
public class EmployeeDao {
	
	@Autowired
	JpaUnit jpa;
	
	EntityManager em=jpa.getEntityManager();
	public void insert(Employee e) {
		em.getTransaction().begin();
		Employee employee=findId(e.getId());
		if(employee==null) {
			em.persist(e);
		}
		else {
			System.out.print("Data exist");
		}
		em.getTransaction().commit();
		
	}   
	
	public Employee findId(int id) {
		return em.find(Employee.class, id);
	}
	

}
