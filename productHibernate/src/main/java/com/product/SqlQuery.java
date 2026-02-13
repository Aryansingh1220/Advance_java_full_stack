package com.product;
import javax.persistence.*;
import java.util.*;
public class SqlQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
//		String sql="Select * from product";
//		Query query=em.createNativeQuery(sql);
		
//		String sql="Select p from Product p";
//		Query query=em.createQuery(sql);
		
		
//		String sql="update product set price=?1 where price>=?2";
//		et.begin();
//		Query query=em.createNativeQuery(sql);
//		query.setParameter(1, 15);
//		query.setParameter(2, 159);
//		
//		query.executeUpdate();
//		et.commit();
//		List<Product>list=query.getResultList();
//		System.out.println(list);
		
		
		String jpql="select p from Product p where p.price>=:a and p.quantity>=:b";
		Query query=em.createQuery(jpql);
		query.setParameter("a", 5);
		query.setParameter("b", 0);
		
		List<Product >list=query.getResultList();
		for(Product p:list) {
			System.out.println(p);
		}
		

	}

}
