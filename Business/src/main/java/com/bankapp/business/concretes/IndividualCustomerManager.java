package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.mappings.IndividualCustomerMapper;
import com.bankapp.business.rules.IndividualCustomerBusinessRules;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.repositories.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public IndividualCustomerResponse create(IndividualCustomerCreateRequest request) {
        individualCustomerBusinessRules.validateIndividualCustomer(request);
        IndividualCustomer customer = individualCustomerMapper.mapToIndividualCustomer(request);
        IndividualCustomer savedCustomer = individualCustomerRepository.save(customer);
        return individualCustomerMapper.mapToIndividualCustomerResponse(savedCustomer);
    }


    @Override
    public IndividualCustomerResponse getById(Long id) {
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(id);
        IndividualCustomer customer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Individual customer not found with id: " + id));
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public void delete(Long id) {
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(id);
        individualCustomerRepository.deleteById(id);
    }


    @Override
    public IndividualCustomerResponse formatResponse(IndividualCustomerResponse response) {
        return individualCustomerBusinessRules.formatResponse(response);
    }
} 