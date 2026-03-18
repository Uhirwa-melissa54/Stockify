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
    private com.sales.model.Product product;

    private int quantity;

    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private com.sales.model.Customer customer;

    // getters and setters
}