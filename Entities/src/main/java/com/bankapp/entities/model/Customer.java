package com.bankapp.entities.model;

import java.util.Random;

import com.bankapp.core.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer extends BaseEntity<Long> {

    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @PrePersist
    protected void onCreateCustomer(){
        if (customerNumber == null){
            Random random = new Random();
            customerNumber = String.format("%06d", random.nextInt(1000000));
        }
    }
} 