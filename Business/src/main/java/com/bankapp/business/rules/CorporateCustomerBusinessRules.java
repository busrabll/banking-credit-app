package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.entities.model.CorporateCustomer;
import com.bankapp.repositories.CorporateCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorporateCustomerBusinessRules {
    private final CorporateCustomerRepository corporateCustomerRepository;

    public void checkIfCorporateCustomerExists(Long id) {
        if (!corporateCustomerRepository.existsById(id)) {
            throw new RuntimeException(String.format(Messages.CORPORATE_CUSTOMER_NOT_FOUND, id));
        }
    }

    public void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new RuntimeException(String.format(Messages.CORPORATE_CUSTOMER_ALREADY_EXISTS, taxNumber));
        }
    }

    public void checkIfEmailExists(String email) {
        if (corporateCustomerRepository.existsByEmail(email)) {
            throw new RuntimeException(String.format(Messages.EMAIL_ALREADY_EXISTS, email));
        }
    }

    public void validateCorporateCustomer(CorporateCustomerCreateRequest request) {
        checkIfTaxNumberExists(request.getTaxNumber());
        checkIfEmailExists(request.getEmail());
        // Diğer validasyonlar buraya eklenebilir
    }

    public void validateCorporateCustomer(CorporateCustomer customer) {
        if (customer == null) {
            throw new RuntimeException(Messages.CORPORATE_CUSTOMER_NOT_FOUND);
        }
        // Diğer validasyonlar buraya eklenebilir
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{10}$";
        return phoneNumber.matches(phoneRegex);
    }
} 