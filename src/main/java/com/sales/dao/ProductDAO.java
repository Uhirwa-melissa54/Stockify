package com.sales.dao;

import com.sales.models.Product;

public class ProductDAO extends GenericDAO<Product> {

    public ProductDAO() {
        super(Product.class);
    }

    // Optional: add findByName or search methods
}