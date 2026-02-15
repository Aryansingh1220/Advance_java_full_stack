package com.OneToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		
		String deleteCS="delete from college_student2 where studentId=?1";
		String sql1="delete from student2 where studentId=?1";
		
		Query delete_college_student=em.createNativeQuery(deleteCS);
		
		Query delete_student=em.createNativeQuery(sql1);
		
		delete_college_student.setParameter(1, 101);
		delete_student.setParameter(1, 101);
		
		et.begin();
		delete_college_student.executeUpdate();
		delete_student.executeUpdate();
		
		et.commit();
	}

}
