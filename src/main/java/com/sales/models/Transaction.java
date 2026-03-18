package com.sales.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;

    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Customer customer;

    // getters and setters
}