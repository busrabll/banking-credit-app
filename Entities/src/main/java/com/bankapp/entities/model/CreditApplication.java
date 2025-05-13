package com.bankapp.entities.model;

import com.bankapp.core.entity.BaseEntity;
import com.bankapp.entities.enums.CreditApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "credit_applications")
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplication extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_type_id", nullable = false)
    private CreditType creditType;
    
    @Column(name= "amount", nullable = false)
    private Double amount;
    
    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "monthly_payment")
    private Double monthlyPayment;

    @Column(name = "total_payment")
    private Double totalPayment;

    @Column(name = "interest_rate")
    private Double interestRate;
    
    @Enumerated(EnumType.STRING)
    @Column(name= "status", nullable = false)
    private CreditApplicationStatus status = CreditApplicationStatus.PENDING;
    
    @Column(name= "rejection_reason")
    private String rejectionReason;
} 