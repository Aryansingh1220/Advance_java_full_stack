package com.basics;

import javax.persistence.*;

public class UserDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	
	
	public void insertUser() {
		EntityTransaction et=em.getTransaction();
		User user=new User();
		user.setId(1);
		user.setName("Allen");
		user.setBalance(10000);
		
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public User findByID(int id) {
	 	return em.find(User.class, 1);
	}

}
