package com.bankapp.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bankapp.business.abstracts.CreditApplicationService;
import com.bankapp.business.dtos.requests.CreditApplicationCreateRequest;
import com.bankapp.business.dtos.responses.CreditApplicationResponse;
import com.bankapp.business.rules.CreditApplicationBusinessRules;
import com.bankapp.business.mappings.CreditApplicationMapper;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.core.utilities.results.PaginatedDataResponse;
import com.bankapp.entities.enums.CreditApplicationStatus;
import com.bankapp.entities.model.CreditApplication;
import com.bankapp.entities.model.CreditType;
import com.bankapp.entities.model.Customer;
import com.bankapp.repositories.abstracts.CreditApplicationRepository;
import com.bankapp.repositories.abstracts.CreditTypeRepository;
import com.bankapp.repositories.abstracts.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditApplicationManager implements CreditApplicationService {

    private CreditApplicationRepository creditApplicationRepository;
    private CustomerRepository<Customer> customerRepository;
    private CreditTypeRepository creditTypeRepository;
    private CreditApplicationMapper mapper;
    private CreditApplicationBusinessRules rules;

    @Override
    @Transactional
    public CreditApplicationResponse apply(CreditApplicationCreateRequest request) {

        rules.checkIfCustomerExists(request.getCustomerId());
        rules.checkIfCreditTypeExists(request.getCreditTypeId());

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow();
        CreditType creditType = creditTypeRepository.findById(request.getCreditTypeId())
                .orElseThrow();

        rules.checkIfCustomerCanApplyForCreditType(customer, creditType);
        rules.checkIfAmountInRange(request.getAmount(), creditType);
        rules.checkIfTermInRange(request.getTerm(), creditType);

        var application = new CreditApplication();
        application.setCustomer(customer);
        application.setCreditType(creditType);
        application.setAmount(request.getAmount());
        application.setTerm(request.getTerm());
        application.setInterestRate(creditType.getBaseInterestRate());

        calculatePayments(application);

        application = creditApplicationRepository.save(application);
        return mapper.mapToResponse(application);
    }

    @Override
    public CreditApplicationResponse getById(Long id) {
        rules.checkIfApplicationExists(id);
        var application = creditApplicationRepository.findById(id).orElseThrow();
        return mapper.mapToResponse(application);
    }

    @Override
    public PaginatedDataResponse<CreditApplicationResponse> getAllByCustomerId(Long customerId, Pageable pageable){
        rules.checkIfCustomerExists(customerId);

        Page<CreditApplicationResponse> applicationPage = creditApplicationRepository.findAllByCustomer();

        List<CreditApplicationResponse> responses = applicationPage.getContent()
            .stream()
            .map(mapper::mapToResponse)
            .toList();

            return new PaginatedDataResponse<>(
                responses,
                applicationPage.getNumber(),
                applicationPage.getSize(),
                applicationPage.getTotalPages(),
                applicationPage.getTotalElements(),
                applicationPage.hasNext(),
                applicationPage.hasPrevious(),
                applicationPage.isFirst(),
                applicationPage.isLast()
            );

    }

    @Override
    @Transactional
    public CreditApplicationResponse cancel(Long id) {
        rules.checkIfApplicationExists(id);
        var application = creditApplicationRepository.findById(id).orElseThrow();

        rules.checkIfApplicatonCanBeCancelled(application);

        //application.setStatus(CreditApplicationStatus.CANCELLED);
        application = creditApplicationRepository.save(application);

        return mapper.mapToResponse(application);
    }

    private void calculatePayments(CreditApplication application) {
        double amount = application.getAmount();
        int term = application.getTerm();
        double monthlyInterestRate = application.getInterestRate() / 12 / 100;

        double monthlyPayment = amount *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, term)) /
                (Math.pow(1 + monthlyInterestRate, term) - 1);

        double totalPayment = monthlyPayment * term;

        application.setMonthlyPayment(Math.round(monthlyPayment * 100.0) / 100.0);
        application.setTotalPayment(Math.round(totalPayment * 100.0) / 100.0);
    }
}