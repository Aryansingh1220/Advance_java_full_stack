package com.BloggingAssesment;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostDAO {

    public void save(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(post);

        tx.commit();
        session.close();
    }

    public List<Post> findByUser(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Post> posts = session.createQuery(
                "FROM Post p WHERE p.author.id = :uid", Post.class)
                .setParameter("uid", userId)
                .getResultList();

        session.close();
        return posts;
    }

    public Post findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    public void delete(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.remove(post);

        tx.commit();
        session.close();
    }
}