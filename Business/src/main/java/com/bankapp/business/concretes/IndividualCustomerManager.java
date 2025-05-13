package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.business.mappings.IndividualCustomerMapper;
import com.bankapp.business.rules.IndividualCustomerBusinessRules;
import com.bankapp.core.utilities.results.PaginatedDataResponse;
import com.bankapp.repositories.abstracts.IndividualCustomerRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

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

    @Override
    public IndividualCustomerResponse getByCustomerNumber(String customerNumber) {
        IndividualCustomer customer = individualCustomerRepository.findByCustomerNumber(customerNumber);
        return individualCustomerMapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public PaginatedDataResponse<IndividualCustomerResponse> getAllPaged(Pageable pageable) {

        Page<IndividualCustomer> customerPage = individualCustomerRepository.findAll(pageable);

        List<IndividualCustomerResponse> responses = customerPage.getContent()
                .stream()
                .map(individualCustomerMapper::mapToIndividualCustomerResponse)
                .toList();

        return new PaginatedDataResponse<IndividualCustomerResponse>(
                responses,
                customerPage.getNumber(),
                customerPage.getSize(),
                customerPage.getTotalPages(),
                customerPage.getTotalElements(),
                customerPage.hasNext(),
                customerPage.hasPrevious(),
                customerPage.isFirst(),
                customerPage.isLast());
    }
}