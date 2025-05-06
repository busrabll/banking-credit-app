package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.mappings.IndividualCustomerMapper;
import com.bankapp.business.rules.IndividualCustomerBusinessRules;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public IndividualCustomerResponse create(IndividualCustomerCreateRequest request) {
        individualCustomerBusinessRules.checkIfNationalIdExists(request.getNationalId());
        var customer = individualCustomerMapper.mapToIndividualCustomer(request);
        customer = individualCustomerRepository.save(customer);
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }


    @Override
    public IndividualCustomerResponse getByCustomerNumber(String customerNumber) {
        var customer = individualCustomerRepository.findByCustomerNumber(customerNumber);
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public IndividualCustomerResponse getByNationalId(String nationalId) {
        var customer = individualCustomerRepository.findByNationalId(nationalId);
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }
} 