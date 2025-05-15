package com.bankapp.business.mappings;

import org.mapstruct.Mapper;

import com.bankapp.business.dtos.requests.CorporateCreditTypeCreateRequest;
import com.bankapp.business.dtos.requests.IndividualCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCreditTypeResponse;
import com.bankapp.business.dtos.responses.IndividualCreditTypeResponse;
import com.bankapp.entities.model.CorporateCreditType;
import com.bankapp.entities.model.IndividualCreditType;

@Mapper(componentModel = "spring")
public interface CreditTypeMapper {
	
	IndividualCreditType mapToIndividualCreditType(IndividualCreditTypeCreateRequest request);
	CorporateCreditType mapToCorporateCreditType(CorporateCreditTypeCreateRequest request);
	
	IndividualCreditTypeResponse mapToIndividualCreditTypeResponse(IndividualCreditType creditType);
	CorporateCreditTypeResponse mapToCorporateCreditTypeResponse(CorporateCreditType creditType);

}
