package com.sales.dao;

import com.sales.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenericDAO<T> {

    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    public T findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T entity = session.get(clazz, id);
        session.close();
        return entity;
    }

    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> list = session.createQuery("FROM " + clazz.getSimpleName(), clazz).list();
        session.close();
        return list;
    }
}