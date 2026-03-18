package com.sales.dao;

import com.sales.models.User;
import com.sales.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }

    public User findByEmailAndPassword(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(
                "FROM User WHERE email = :email AND password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public User findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        User user = query.uniqueResult();
        session.close();
        return user;
    }
}