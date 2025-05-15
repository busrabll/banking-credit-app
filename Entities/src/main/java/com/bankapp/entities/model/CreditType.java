package com.bankapp.entities.model;

import com.bankapp.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "credit_types")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class CreditType extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name= "min_amount", nullable = false)
    private Double minAmount;
    
    @Column(name= "max_amount", nullable = false)
    private Double maxAmount;
    
    @Column(name= "min_term", nullable = false)
    private Integer minTerm;
    
    @Column(name= "max_term", nullable = false)
    private Integer maxTerm;
    
    @Column(name= "base_interest_rate", nullable = false)
    private Double baseInterestRate;
    
    @Column(name= "is_active", nullable = false)
    private boolean active = true;
} 