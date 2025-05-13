package com.bankapp.business.dtos.responses;

import java.time.LocalDateTime;

import com.bankapp.entities.enums.CreditApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationResponse {

    private Long id;
    private Long customerNumber;
    private String customerFullName;
    private String creditTypeName;
    private Double amount;
    private Integer term;
    private Double monthlyPayment;
    private Double totalPayment;
    private Double interestRate;
    private CreditApplicationStatus status;
    private String rejectionReason;
    private LocalDateTime createdDate;
} 