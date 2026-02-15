package weeklyCaseStudy1;

import javax.persistence.*;

public class OrderDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveOrder(PurchaseOrder o) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(o);
        et.commit();

        em.close();
    }

    public PurchaseOrder findOrder(long id) {

        EntityManager em = emf.createEntityManager();
        PurchaseOrder po = em.find(PurchaseOrder.class, id);

        em.close();
        return po;
    }

    public void updateOrder(PurchaseOrder o) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(o);
        et.commit();

        em.close();
    }
}
