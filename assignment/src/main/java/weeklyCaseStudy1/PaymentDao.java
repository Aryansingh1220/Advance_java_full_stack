package weeklyCaseStudy1;

import javax.persistence.*;

public class PaymentDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void savePayment(Payment p) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(p);
        et.commit();

        em.close();
    }

    public Payment findPayment(long id) {

        EntityManager em = emf.createEntityManager();
        Payment pay = em.find(Payment.class, id);

        em.close();
        return pay;
    }
}
