package ManyToManyBidirecational;

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
		
		Student3 s1=new Student3();
		s1.setId(1);
		s1.setName("Miller");
		s1.setBranch("CSE");
		
		Student3 s2=new Student3();
		s2.setId(2);
		s2.setName("Rohit");
		s2.setBranch("ECE");
		
		
		
		Subject sub1=new Subject();
		sub1.setId(100);
		sub1.setName("MicroProcessor");
		
		Subject sub2=new Subject();
		sub2.setId(101);
		
		sub2.setName("ML");
		
		Subject sub3=new Subject();
		sub3.setId(102);
		sub3.setName("Software Engineering");
		
		
		List<Student3>stu=List.of(s1,s2);
		List<Subject> sub=List.of(sub1,sub2,sub3);
		
		
		// student ------> subject
		s1.setSubject(sub);
		s2.setSubject(sub);
		
		
		// subject -----> student
		sub1.setStudent(stu);
		sub2.setStudent(stu);
		sub3.setStudent(stu);
		
		
		
		et.begin();
		em.persist(s1);
		em.persist(s2);
		et.commit();
		em.close();
	}

}
