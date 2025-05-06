package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {
    IndividualCustomerResponse create(IndividualCustomerCreateRequest request);
    IndividualCustomerResponse getById(Long id);
    void delete(Long id);
} 