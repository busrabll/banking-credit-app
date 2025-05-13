package com.bankapp.business.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditApplicationCreateRequest {

    @NotNull
    private Long creditTypeId;

    @NotNull
    private Long customerId;

    @NotNull
    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;

    @NotNull
    @Min(value = 1, message = "Term must be greater than 0")
    private Integer term;
} 