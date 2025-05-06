package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.responses.CustomerResponse;

public interface CustomerService<T extends CustomerResponse> {

    T getByCustomerNumber(String customerNumber);
} 