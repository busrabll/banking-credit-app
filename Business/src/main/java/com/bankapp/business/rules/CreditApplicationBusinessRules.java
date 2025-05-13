package com.bankapp.business.rules;

import org.springframework.stereotype.Service;

import com.bankapp.business.constants.Messages;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.repositories.abstracts.CreditApplicationRepository;
import com.bankapp.repositories.abstracts.CreditTypeRepository;
import com.bankapp.repositories.abstracts.CustomerRepository;
import com.bankapp.entities.model.Customer;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.entities.model.CreditType;
import com.bankapp.entities.model.IndividualCreditType;
import com.bankapp.entities.model.CreditApplication;
import com.bankapp.entities.enums.CreditApplicationStatus;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditApplicationBusinessRules {

    private CustomerRepository<Customer> customerRepository;
    private CreditTypeRepository creditTypeRepository;
    private CreditApplicationRepository creditApplicationRepository;

    public void checkIfCustomerExists(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new BusinessException(Messages.Customer.CUSTOMER_NOT_FOUND);
        }
    }

    public void checkIfCreditTypeExists(Long creditTypeId) {
        if (!creditTypeRepository.existsById(creditTypeId)) {
            throw new BusinessException(Messages.Credit.CREDIT_TYPE_NOT_FOUND);
        }
    }

    public void checkIfApplicationExists(Long id) {
        if (!creditApplicationRepository.existsById(id)) {
            throw new BusinessException(Messages.Credit.APPLICATION_NOT_FOUND);
        }
    }

    public void checkIfCustomerCanApplyForCreditType(Customer customer, CreditType creditType) {
        boolean isIndividualCustomer = customer instanceof IndividualCustomer;
        boolean isIndividualCreditType = creditType instanceof IndividualCreditType;

        if (isIndividualCustomer != isIndividualCreditType) {
            throw new BusinessException(Messages.Credit.INVALID_CREDIT_TYPE_FOR_CUSTOMER);
        }
    }

    public void checkIfAmountInRange(Double amount, CreditType creditType) {
        if (amount < creditType.getMinAmount() || amount > creditType.getMaxAmount()) {
            throw new BusinessException(Messages.Credit.AMOUNT_OUT_OF_RANGE);
        }
    }

    public void checkIfTermInRange(Integer term, CreditType creditType) {
        if (term < creditType.getMinTerm() || term > creditType.getMaxTerm()) {
            throw new BusinessException(Messages.Credit.TERM_OUT_OF_RANGE);
        }
    }

    public void checkIfApplicatonCanBeCancelled(CreditApplication application) {
        if (application.getStatus() != CreditApplicationStatus.PENDING) {
            throw new BusinessException(Messages.Credit.APPLICATION_CANNOT_BE_CANCELLED);
        }
    }
}
