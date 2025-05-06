package com.bankapp.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IndividualCustomerResponse extends CustomerResponse {

    private String firstName;
    private String lastName;
    private String nationalId;
    private String birthDate;
} 