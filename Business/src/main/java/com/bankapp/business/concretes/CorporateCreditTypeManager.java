package com.bankapp.business.concretes;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bankapp.business.abstracts.CorporateCreditTypeService;
import com.bankapp.business.dtos.requests.CorporateCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCreditTypeResponse;
import com.bankapp.business.mappings.CreditTypeMapper;
import com.bankapp.business.rules.CreditTypeBusinessRules;
import com.bankapp.core.utilities.results.PaginatedDataResponse;
import com.bankapp.entities.model.CorporateCreditType;
import com.bankapp.repositories.abstracts.CreditTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CorporateCreditTypeManager implements CorporateCreditTypeService {

	private CreditTypeRepository<CorporateCreditType> repository;
	private CreditTypeMapper mapper;
	private CreditTypeBusinessRules rules;

	@Override
	public CorporateCreditTypeResponse add(CorporateCreditTypeCreateRequest request) {
		rules.checkIfNameExists(request.getName());

		var creditType = mapper.mapToCorporateCreditType(request);
		creditType = repository.save(creditType);
		return mapper.mapToCorporateCreditTypeResponse(creditType);
	}

	@Override
	public CorporateCreditTypeResponse getById(Long id) {
		rules.checkIfExists(id);
		var creditType = repository.findById(id).orElseThrow();
		return mapper.mapToCorporateCreditTypeResponse(creditType);
	}

	@Override
	public PaginatedDataResponse<CorporateCreditTypeResponse> getAllPaged(Pageable pageable) {
		Page<CorporateCreditType> creditTypePage = repository.findAll(pageable);

		List<CorporateCreditTypeResponse> responses = creditTypePage.getContent().stream()
				.map(mapper::mapToCorporateCreditTypeResponse).toList();

		return new PaginatedDataResponse<>(responses, creditTypePage.getNumber(), creditTypePage.getSize(),
				creditTypePage.getTotalPages(), creditTypePage.getTotalElements(), creditTypePage.hasNext(),
				creditTypePage.hasPrevious(), creditTypePage.isFirst(), creditTypePage.isLast());
	}

	@Override
	public CorporateCreditTypeResponse activate(Long id) {
		rules.checkIfExists(id);
		var creditType = repository.findById(id).orElseThrow();
		creditType.setActive(true);
		creditType = repository.save(creditType);
		return mapper.mapToCorporateCreditTypeResponse(creditType);
	}

	@Override
	public CorporateCreditTypeResponse deactivate(Long id) {
		rules.checkIfExists(id);
		var creditType = repository.findById(id).orElseThrow();
		creditType.setActive(false);
		creditType = repository.save(creditType);
		return mapper.mapToCorporateCreditTypeResponse(creditType);
	}

}
