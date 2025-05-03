package com.bankapp.entities.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@DiscriminatorValue("CORPORATE")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "tax_number", unique = true, nullable = false)
    private String taxNumber;

    @Column(name = "tax_office", nullable = false)
    private String taxOffice;

    @Column(name = "company_registration_number", unique = true, nullable = false)
    private String companyRegistrationNumber;

    @Column(name = "establishment_date", nullable = false)
    private LocalDate establishmentDate;

    @Column(name = "company_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    public enum CompanyType {
        LIMITED_COMPANY,
        JOINT_STOCK_COMPANY,
        COOPERATIVE,
        OTHER
    }
} 