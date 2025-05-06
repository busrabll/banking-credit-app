package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.CorporateCustomerService;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.business.mappings.CorporateCustomerMapper;
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
    private final CorporateCustomerMapper corporateCustomerMapper;
    private final CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Override
    public CorporateCustomerResponse create(CorporateCustomerCreateRequest request) {
        corporateCustomerBusinessRules.validateCorporateCustomer(request);
        CorporateCustomer customer = corporateCustomerMapper.mapToCorporateCustomer(request);
        CorporateCustomer savedCustomer = corporateCustomerRepository.save(customer);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(savedCustomer);
    }

    @Override
    public CorporateCustomerResponse getById(Long id) {
        corporateCustomerBusinessRules.checkIfCorporateCustomerExists(id);
        CorporateCustomer customer = corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corporate customer not found with id: " + id));
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }


    @Override
    public void delete(Long id) {
        corporateCustomerBusinessRules.checkIfCorporateCustomerExists(id);
        corporateCustomerRepository.deleteById(id);
    }
    
    @Override
    public CorporateCustomerResponse formatResponse(CorporateCustomerResponse response) {
        return corporateCustomerBusinessRules.formatResponse(response);
    }
} 