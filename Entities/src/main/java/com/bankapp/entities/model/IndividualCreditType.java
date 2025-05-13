package com.bankapp.entities.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "individual_credit_types")
@PrimaryKeyJoinColumn(name = "credit_type_id")
@AllArgsConstructor
public class IndividualCreditType extends CreditType {

    @Column(name = "min_credit_score", nullable = false)
    private Integer minCreditScore;

    @Column(name = "requires_guarantor")
    private Boolean requiresGuarantor = false;
} 