package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService extends CustomerService<CorporateCustomerResponse> {
    CorporateCustomerResponse create(CorporateCustomerCreateRequest request);
    CorporateCustomerResponse getById(Long id);
    void delete(Long id);
} 