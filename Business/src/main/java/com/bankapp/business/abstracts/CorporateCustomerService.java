package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.requests.CorporateCustomerUpdateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.business.dtos.responses.CorporateCustomerListResponse;

import java.util.List;

public interface CorporateCustomerService extends CustomerService<CorporateCustomerResponse> {
    CorporateCustomerResponse create(CorporateCustomerCreateRequest request);
    CorporateCustomerResponse update(Long id, CorporateCustomerUpdateRequest request);
    CorporateCustomerResponse getById(Long id);
    List<CorporateCustomerListResponse> getAll();
    void delete(Long id);
} 