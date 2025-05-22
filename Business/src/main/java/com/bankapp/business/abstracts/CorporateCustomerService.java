package com.bankapp.business.abstracts;

import org.springframework.data.domain.Pageable;

import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;


public interface CorporateCustomerService extends CustomerService<CorporateCustomerResponse> {
    CorporateCustomerResponse create(CorporateCustomerCreateRequest request);
    CorporateCustomerResponse getByTaxNumber(String taxNumber);
    CorporateCustomerResponse getByCustomerNumber(String customerNumber);
    PaginatedDataResponse<CorporateCustomerResponse> getAllPaged(Pageable pageable);
} 