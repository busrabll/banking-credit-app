package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {

    IndividualCustomerResponse create(IndividualCustomerCreateRequest request);
    IndividualCustomerResponse getByNationalId(String nationalId);
} 