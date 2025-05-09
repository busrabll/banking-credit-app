package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.mappings.IndividualCustomerMapper;
import com.bankapp.business.rules.IndividualCustomerBusinessRules;
import com.bankapp.repositories.abstracts.IndividualCustomerRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {

    private IndividualCustomerRepository individualCustomerRepository;
    private IndividualCustomerMapper individualCustomerMapper;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public IndividualCustomerResponse create(IndividualCustomerCreateRequest request) {
        individualCustomerBusinessRules.checkIfNationalIdExists(request.getNationalId());
        var customer = individualCustomerMapper.mapToIndividualCustomer(request);
        customer = individualCustomerRepository.save(customer);
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public IndividualCustomerResponse getByNationalId(String nationalId) {
        var customer = individualCustomerRepository.findByNationalId(nationalId);
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }
} 