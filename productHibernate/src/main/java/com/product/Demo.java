package com.product;
import javax.persistence.*;

import java.util.*;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
//		String jpql="select p from Product p where p.price=?1";
//		
//		Query query =em.createQuery(jpql);
//		
//		query.setParameter(1, 100);
//		List<Product>list=query.getResultList();
//		
//		list.forEach(i->System.out.println(i.getName()));
		
		String jpql ="select p from Product p where p.price>=?1 and p.quantity>=?2";
		Query query=em.createQuery(jpql);
		query.setParameter(1, 15);
		query.setParameter(2, 20);
		List<Product>list=query.getResultList();
		for(Product p:list) {
			System.out.println(p);
		}
	}

}
