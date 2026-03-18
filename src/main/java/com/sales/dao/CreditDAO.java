package com.sales.dao;

import com.sales.models.Credit;

import java.util.List;

public class CreditDAO extends GenericDAO<Credit> {

    public CreditDAO() {
        super(Credit.class);
    }

    public List<Credit> findUnpaid() {
        return findAll().stream()
                .filter(c -> c.getStatus().equalsIgnoreCase("UNPAID"))
                .toList();
    }
}