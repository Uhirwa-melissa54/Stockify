package com.sales.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private com.sales.models.Product product;

    private int quantity;

    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private com.sales.models.Customer customer;

    public Transaction(Long id, Product product, int quantity, double totalPrice, TransactionType type, Date date, Customer customer) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.type = type;
        this.date = date;
        this.customer = customer;
    }
    public Transaction() {}
}