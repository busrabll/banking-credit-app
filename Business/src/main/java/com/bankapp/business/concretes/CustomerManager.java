package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.CustomerService;
import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.responses.CustomerResponse;
import com.bankapp.repositories.BaseCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class CustomerManager<T extends CustomerResponse> implements CustomerService<T> {
    protected final BaseCustomerRepository<T> customerRepository;

    @Override
    public T formatResponse(T response) {
        if (response != null) {
            response.setPhoneNumber(formatPhoneNumber(response.getPhoneNumber()));
            response.setAddress(formatAddress(response.getAddress()));
        }
        return response;
    }

    @Override
    public String formatPhoneNumber(String phoneNumber) {
        // Telefon numarası formatlama işlemi
        return phoneNumber.replaceAll("[^0-9]", "");
    }

    @Override
    public String formatAddress(String address) {
        // Adres formatlama işlemi
        return address.trim();
    }

    protected T getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(Messages.CUSTOMER_NOT_FOUND, id)));
    }
} 