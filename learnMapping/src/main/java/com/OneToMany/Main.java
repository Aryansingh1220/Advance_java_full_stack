package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory; 
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction(); 
		
		Student s1=new Student();
		s1.setStudentId(108);
		s1.setName("Bullauu");
		s1.setBranch("CSE");
		
		
		Student s2=new Student();
		s2.setStudentId(19);
		s2.setName("Pillauu");
		s2.setBranch("ECE");
		
		 
		College c=new College();
		c.setId(2);
		c.setName("LPUuu");
		c.setLocation("Punjab");
		c.setPincode("144411");
		
		List<Student>list=new ArrayList();
		list.add(s1); 
		list.add(s2);
		
		c.setS(list);
		
		et.begin();
		
		em.persist(s1);
		em.persist(s2);
		em.persist(c);
		et.commit();
		
		
		

	}

}
