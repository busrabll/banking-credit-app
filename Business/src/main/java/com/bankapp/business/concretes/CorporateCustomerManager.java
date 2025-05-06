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
        corporateCustomerBusinessRules.checkIfTaxNumberExists(request.getTaxNumber());
        var customer = corporateCustomerMapper.mapToCorporateCustomer(request);
        customer = corporateCustomerRepository.save(customer);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }

    @Override
    public CorporateCustomerResponse getByCustomerNumber(String customerNumber) {
        var customer = corporateCustomerRepository.findByCustomerNumber(customerNumber);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }

    @Override
    public CorporateCustomerResponse getByTaxNumber(String taxNumber) {
        var customer = corporateCustomerRepository.findByTaxNumber(taxNumber);
        return corporateCustomerMapper.mapToCorporateCustomerResponse(customer);
    }

} 