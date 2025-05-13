package com.bankapp.entities.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "corporate_credit_types")
@PrimaryKeyJoinColumn(name = "credit_type_id")
@AllArgsConstructor
public class CorporateCreditType extends CreditType {

    @Column(name = "min_company_age", nullable = false)
    private Integer minCompanyAge;

    @Column(name = "min_revenue", nullable = false)
    private Double minRevenue;

    @Column(name = "requires_collateral")
    private Boolean requiresCollateral = false;
} 