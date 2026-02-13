package com.product;
import javax.persistence.*;
public class UpdateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		String jpql="Update Product p set p.price=?1 where p.price=?2";
		
		et.begin();
		Query query=em.createQuery(jpql);
		query.setParameter(1, 1000);
		query.setParameter(2, 50);
		query.executeUpdate();
		et.commit();
		em.close();
		emf.close();
	}

}
