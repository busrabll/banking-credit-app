package com.bankapp.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CorporateCustomerResponse extends CustomerResponse {

    private String companyName;
    private String taxNumber;
    private String tradeRegisterNumber;
    private String contactPerson;
} 