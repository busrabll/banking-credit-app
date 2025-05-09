package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.repositories.abstracts.CorporateCustomerRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CorporateCustomerBusinessRules {
    
    private CorporateCustomerRepository corporateCustomerRepository;

    public void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(Messages.Customer.TAX_NUMBER_ALREADY_EXISTS);
        }
    }
} 