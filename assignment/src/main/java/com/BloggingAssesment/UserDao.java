package com.BloggingAssesment;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(user);

        tx.commit();
        session.close();
    }

    public User findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
}