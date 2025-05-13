package com.bankapp.business.abstracts;

import com.bankapp.core.utilities.results.PaginatedDataResponse;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import org.springframework.data.domain.Pageable;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {

    IndividualCustomerResponse create(IndividualCustomerCreateRequest request);
    IndividualCustomerResponse getByNationalId(String nationalId);
    IndividualCustomerResponse getByCustomerNumber(String customerNumber);
    PaginatedDataResponse<IndividualCustomerResponse> getAllPaged(Pageable pageable);
}