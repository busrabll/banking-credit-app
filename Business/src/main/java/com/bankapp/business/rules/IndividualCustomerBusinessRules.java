package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;

    public void checkIfNationalIdExists(String nationalId) {
        if (individualCustomerRepository.existsByNationalId(nationalId)) {
            throw new BusinessException(Messages.Customer.INDIVIDUAL_CUSTOMER_ALREADY_EXISTS);
        }
    }

    public void checkIfEmailExists(String email) {
        if (individualCustomerRepository.existsByEmail(email)) {
            throw new BusinessException(Messages.Customer.EMAIL_ALREADY_EXISTS);
        }
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