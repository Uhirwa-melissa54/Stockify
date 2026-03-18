package com.sales.dao;

import com.sales.models.Transaction;
import com.sales.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class TransactionDAO extends GenericDAO<Transaction> {

    public TransactionDAO() {
        super(Transaction.class);
    }

    public List<Transaction> findByDateRange(Date start, Date end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Transaction> list = session.createQuery(
                        "FROM Transaction WHERE date BETWEEN :start AND :end", Transaction.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .list();
        session.close();
        return list;
    }
}