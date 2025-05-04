package com.bankapp.business.mappings;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.requests.IndividualCustomerUpdateRequest;
import com.bankapp.business.dtos.requests.CorporateCustomerUpdateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.business.dtos.responses.IndividualCustomerListResponse;
import com.bankapp.business.dtos.responses.CorporateCustomerListResponse;
import com.bankapp.entities.individual.IndividualCustomer;
import com.bankapp.entities.corporate.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    // Individual Customer Mappings
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    IndividualCustomer toIndividualEntity(IndividualCustomerCreateRequest request);

    IndividualCustomerResponse toIndividualResponse(IndividualCustomer entity);

    IndividualCustomerListResponse toIndividualListResponse(IndividualCustomer entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateIndividualEntity(IndividualCustomerUpdateRequest request, @MappingTarget IndividualCustomer entity);

    // Corporate Customer Mappings
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CorporateCustomer toCorporateEntity(CorporateCustomerCreateRequest request);

    CorporateCustomerResponse toCorporateResponse(CorporateCustomer entity);

    CorporateCustomerListResponse toCorporateListResponse(CorporateCustomer entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateCorporateEntity(CorporateCustomerUpdateRequest request, @MappingTarget CorporateCustomer entity);
} 