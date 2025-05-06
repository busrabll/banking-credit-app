package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.entities.model.CorporateCustomer;
import com.bankapp.repositories.CorporateCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorporateCustomerBusinessRules {
    private final CorporateCustomerRepository corporateCustomerRepository;

    public void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(Messages.Customer.TAX_NUMBER_ALREADY_EXISTS);
        }
    }
} 