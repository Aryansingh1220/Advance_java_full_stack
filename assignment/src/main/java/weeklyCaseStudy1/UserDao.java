package weeklyCaseStudy1;

import javax.persistence.*;

public class UserDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveUser(User u) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(u);
        et.commit();

        em.close();
    }

    public User findUser(long id) {

        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);

        if (user != null) {
            user.getPurchaseOrder().size();
            if (user.getProfile() != null)
                user.getProfile().getPhone();
        }

        em.close();
        return user;
    }

    public void deleteUser(long id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = em.find(User.class, id);

        if (user != null) {
            et.begin();
            em.remove(user);
            et.commit();
        }

        em.close();
    }

    public void updateUser(User u) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(u);
        et.commit();

        em.close();
    }
}
