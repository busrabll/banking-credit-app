package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.repositories.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;

    public void checkIfIndividualCustomerExists(Long id) {
        if (!individualCustomerRepository.existsById(id)) {
            throw new RuntimeException(String.format(Messages.INDIVIDUAL_CUSTOMER_NOT_FOUND, id));
        }
    }

    public void checkIfIdentityNumberExists(String identityNumber) {
        if (individualCustomerRepository.existsByIdentityNumber(identityNumber)) {
            throw new RuntimeException(String.format(Messages.INDIVIDUAL_CUSTOMER_ALREADY_EXISTS, identityNumber));
        }
    }

    public void checkIfEmailExists(String email) {
        if (individualCustomerRepository.existsByEmail(email)) {
            throw new RuntimeException(String.format(Messages.EMAIL_ALREADY_EXISTS, email));
        }
    }

    public void validateIndividualCustomer(IndividualCustomerCreateRequest request) {
        checkIfIdentityNumberExists(request.getIdentityNumber());
        checkIfEmailExists(request.getEmail());
        // Diğer validasyonlar buraya eklenebilir
    }

    public void validateIndividualCustomer(IndividualCustomer customer) {
        if (customer == null) {
            throw new RuntimeException(Messages.INDIVIDUAL_CUSTOMER_NOT_FOUND);
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