package com.bankapp.business.mappings;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.entities.model.IndividualCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndividualCustomerMapper {

    IndividualCustomer mapToIndividualCustomer(IndividualCustomerCreateRequest request);
    IndividualCustomerResponse mapToIndividualCustomerResponse(IndividualCustomer customer);
}