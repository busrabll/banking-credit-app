package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.requests.IndividualCustomerUpdateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.dtos.responses.IndividualCustomerListResponse;

import java.util.List;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {
    IndividualCustomerResponse create(IndividualCustomerCreateRequest request);
    IndividualCustomerResponse update(Long id, IndividualCustomerUpdateRequest request);
    IndividualCustomerResponse getById(Long id);
    List<IndividualCustomerListResponse> getAll();
    void delete(Long id);
} 