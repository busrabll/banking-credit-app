package com.bankapp.business.mappings;

import com.bankapp.business.dtos.responses.CreditApplicationResponse;
import com.bankapp.entities.model.CreditApplication;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bankapp.entities.model.IndividualCustomer;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {

    @Mapping(target = "customerNumber", source = "customer.customerNumber")
    @Mapping(target = "customerFullName", expression = "java(getCustomerFullName(application))")
    @Mapping(target = "creditTypeName", source = "creditType.name")
    CreditApplicationResponse mapToResponse(CreditApplication application);

    default String getCustomerFullName(CreditApplication application) {
        if (application.getCustomer() instanceof IndividualCustomer) {
            IndividualCustomer customer = (IndividualCustomer) application.getCustomer();
            return customer.getFirstName() + " " + customer.getLastName();
        }
        return application.getCustomer().getCustomerNumber();
    }
} 