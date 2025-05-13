package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.CorporateCustomerService;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.business.mappings.CorporateCustomerMapper;
import com.bankapp.business.rules.CorporateCustomerBusinessRules;
import com.bankapp.entities.model.CorporateCustomer;
import com.bankapp.repositories.abstracts.CorporateCustomerRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {

    private CorporateCustomerRepository corporateCustomerRepository;
    private CorporateCustomerMapper corporateCustomerMapper;
    private CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Override
    public CorporateCustomerResponse create(CorporateCustomerCreateRequest request) {
        corporateCustomerBusinessRules.checkIfTaxNumberExists(request.getTaxNumber());
        var customer = corporateCustomerMapper.mapToCorporateCustomer(request);
        customer = corporateCustomerRepository.save(customer);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }

    
    @Override
    public CorporateCustomerResponse getByCustomerNumber(String customerNumber) {
        CorporateCustomer customer = corporateCustomerRepository.findByCustomerNumber(customerNumber);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }

    @Override
    public CorporateCustomerResponse getByTaxNumber(String taxNumber) {
        var customer = corporateCustomerRepository.findByTaxNumber(taxNumber);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }

} 