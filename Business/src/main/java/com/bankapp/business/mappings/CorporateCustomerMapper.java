package com.bankapp.business.mappings;

import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.entities.model.CorporateCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CorporateCustomerMapper {

    CorporateCustomer mapToCorporateCustomer(CorporateCustomerCreateRequest request);
    CorporateCustomerResponse mapToCorporateCustomerResponse(CorporateCustomer customer);
} 