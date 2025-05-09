package com.bankapp.entities.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "tax_number", unique = true, nullable = false)
    private String taxNumber;

    @Column(name = "trade_register_number")
    private String tradeRegisterNumber;

    @Column(name = "contact_person")
    private String contactPerson;
} 