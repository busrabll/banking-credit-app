package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.CreditApplicationCreateRequest;
import com.bankapp.business.dtos.responses.CreditApplicationResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;
import org.springframework.data.domain.Pageable;


public interface CreditApplicationService {
    CreditApplicationResponse apply(CreditApplicationCreateRequest request);
    CreditApplicationResponse getById(Long id);
    PaginatedDataResponse<CreditApplicationResponse> getAllByCustomerId(Long customerId, Pageable pageable);
    CreditApplicationResponse cancel(Long id);
} 
