package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;


public interface CorporateCustomerService extends CustomerService<CorporateCustomerResponse> {
    CorporateCustomerResponse create(CorporateCustomerCreateRequest request);
    CorporateCustomerResponse getByTaxNumber(String taxNumber);
    CorporateCustomerResponse getByCustomerNumber(String customerNumber);
} 