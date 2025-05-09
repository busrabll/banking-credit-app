package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.CustomerService;
import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.responses.CustomerResponse;
import com.bankapp.repositories.abstracts.CustomerRepository;
import com.bankapp.entities.model.Customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public abstract class CustomerManager<T extends Customer> implements CustomerService<CustomerResponse> {
    
    private CustomerRepository<T> customerRepository;

    protected T getByCustomerNumber(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(Messages.Customer.CUSTOMER_NOT_FOUND, id)));
    }
} 