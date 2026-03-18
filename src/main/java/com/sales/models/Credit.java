package com.sales.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private double amount;

    private String status; // PAID / UNPAID

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // getters and setters
}