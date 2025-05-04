package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.requests.IndividualCustomerUpdateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.dtos.responses.IndividualCustomerListResponse;
import com.bankapp.business.mappings.CustomerMapper;
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
    private final CustomerMapper customerMapper;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public IndividualCustomerResponse create(IndividualCustomerCreateRequest request) {
        individualCustomerBusinessRules.validateIndividualCustomer(request);
        IndividualCustomer customer = customerMapper.toIndividualEntity(request);
        IndividualCustomer savedCustomer = individualCustomerRepository.save(customer);
        return customerMapper.toIndividualResponse(savedCustomer);
    }

    @Override
    public IndividualCustomerResponse update(Long id, IndividualCustomerUpdateRequest request) {
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(id);
        IndividualCustomer customer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Individual customer not found with id: " + id));
        customerMapper.updateIndividualEntity(request, customer);
        IndividualCustomer updatedCustomer = individualCustomerRepository.save(customer);
        return customerMapper.toIndividualResponse(updatedCustomer);
    }

    @Override
    public IndividualCustomerResponse getById(Long id) {
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(id);
        IndividualCustomer customer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Individual customer not found with id: " + id));
        return customerMapper.toIndividualResponse(customer);
    }

    @Override
    public List<IndividualCustomerListResponse> getAll() {
        List<IndividualCustomer> customers = individualCustomerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toIndividualListResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        individualCustomerBusinessRules.checkIfIndividualCustomerExists(id);
        individualCustomerRepository.deleteById(id);
    }

    @Override
    public void checkIfEmailExists(String email) {
        individualCustomerBusinessRules.checkIfEmailExists(email);
    }

    @Override
    public boolean isValidEmail(String email) {
        return individualCustomerBusinessRules.isValidEmail(email);
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return individualCustomerBusinessRules.isValidPhoneNumber(phoneNumber);
    }

    @Override
    public IndividualCustomerResponse formatResponse(IndividualCustomerResponse response) {
        return individualCustomerBusinessRules.formatResponse(response);
    }
} 