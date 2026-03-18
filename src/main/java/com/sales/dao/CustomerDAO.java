package com.sales.dao;

import com.sales.models.Customer;

public class CustomerDAO extends GenericDAO<Customer> {

    public CustomerDAO() {
        super(Customer.class);
    }

    // Optional: find by name or phone
}