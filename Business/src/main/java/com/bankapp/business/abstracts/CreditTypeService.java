package com.bankapp.business.abstracts;

import org.springframework.data.domain.Pageable;

import com.bankapp.core.utilities.results.PaginatedDataResponse;

public interface CreditTypeService<T, R> {
	
	T add (R request);
	T activate (Long id);
	T deactivate (Long id);
	T getById (Long id);
	PaginatedDataResponse<T> getAllPaged(Pageable pageable);

}
