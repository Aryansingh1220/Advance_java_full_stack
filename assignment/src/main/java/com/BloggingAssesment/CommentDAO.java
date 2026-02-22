package com.BloggingAssesment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentDAO {

    public void save(Comment comment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(comment);

        tx.commit();
        session.close();
    }

    public List<Comment> findByPost(Long postId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Comment> list = session.createQuery(
                "FROM Comment c WHERE c.post.id = :pid", Comment.class)
                .setParameter("pid", postId)
                .getResultList();

        session.close();
        return list;
    }

    public List<Comment> findByUser(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Comment> list = session.createQuery(
                "FROM Comment c WHERE c.author.id = :uid", Comment.class)
                .setParameter("uid", userId)
                .getResultList();

        session.close();
        return list;
    }
}