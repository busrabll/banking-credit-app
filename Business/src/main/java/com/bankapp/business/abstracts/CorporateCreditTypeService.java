package com.bankapp.business.abstracts;

import org.springframework.data.domain.Pageable;

import com.bankapp.business.dtos.requests.CorporateCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCreditTypeResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;

public interface CorporateCreditTypeService extends CreditTypeService<CorporateCreditTypeResponse,CorporateCreditTypeCreateRequest> {
	
	CorporateCreditTypeResponse getById(Long id);
	PaginatedDataResponse<CorporateCreditTypeResponse> getAllPaged(Pageable pageable);
}
