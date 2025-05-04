package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.CorporateCustomerService;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.requests.CorporateCustomerUpdateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.business.dtos.responses.CorporateCustomerListResponse;
import com.bankapp.business.mappings.CustomerMapper;
import com.bankapp.business.rules.CorporateCustomerBusinessRules;
import com.bankapp.entities.model.CorporateCustomer;
import com.bankapp.repositories.CorporateCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final CustomerMapper customerMapper;
    private final CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Override
    public CorporateCustomerResponse create(CorporateCustomerCreateRequest request) {
        corporateCustomerBusinessRules.validateCorporateCustomer(request);
        CorporateCustomer customer = customerMapper.toCorporateEntity(request);
        CorporateCustomer savedCustomer = corporateCustomerRepository.save(customer);
        return customerMapper.toCorporateResponse(savedCustomer);
    }

    @Override
    public CorporateCustomerResponse update(Long id, CorporateCustomerUpdateRequest request) {
        corporateCustomerBusinessRules.checkIfCorporateCustomerExists(id);
        CorporateCustomer customer = corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corporate customer not found with id: " + id));
        customerMapper.updateCorporateEntity(request, customer);
        CorporateCustomer updatedCustomer = corporateCustomerRepository.save(customer);
        return customerMapper.toCorporateResponse(updatedCustomer);
    }

    @Override
    public CorporateCustomerResponse getById(Long id) {
        corporateCustomerBusinessRules.checkIfCorporateCustomerExists(id);
        CorporateCustomer customer = corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corporate customer not found with id: " + id));
        return customerMapper.toCorporateResponse(customer);
    }

    @Override
    public List<CorporateCustomerListResponse> getAll() {
        List<CorporateCustomer> customers = corporateCustomerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toCorporateListResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        corporateCustomerBusinessRules.checkIfCorporateCustomerExists(id);
        corporateCustomerRepository.deleteById(id);
    }

    @Override
    public void checkIfEmailExists(String email) {
        corporateCustomerBusinessRules.checkIfEmailExists(email);
    }

    @Override
    public boolean isValidEmail(String email) {
        return corporateCustomerBusinessRules.isValidEmail(email);
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return corporateCustomerBusinessRules.isValidPhoneNumber(phoneNumber);
    }

    @Override
    public CorporateCustomerResponse formatResponse(CorporateCustomerResponse response) {
        return corporateCustomerBusinessRules.formatResponse(response);
    }
} 