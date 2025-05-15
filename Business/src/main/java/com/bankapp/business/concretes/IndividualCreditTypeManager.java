package com.bankapp.business.concretes;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bankapp.business.abstracts.IndividualCreditTypeService;
import com.bankapp.business.dtos.requests.IndividualCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCreditTypeResponse;
import com.bankapp.business.mappings.CreditTypeMapper;
import com.bankapp.business.rules.CreditTypeBusinessRules;
import com.bankapp.core.utilities.results.PaginatedDataResponse;
import com.bankapp.entities.model.IndividualCreditType;
import com.bankapp.repositories.abstracts.CreditTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualCreditTypeManager implements IndividualCreditTypeService {

	private CreditTypeRepository<IndividualCreditType> repository;
	private CreditTypeMapper mapper;
	private CreditTypeBusinessRules rules;

	@Override
	public IndividualCreditTypeResponse add(IndividualCreditTypeCreateRequest request) {
		rules.checkIfNameExists(request.getName());

		var creditType = mapper.mapToIndividualCreditType(request);
		creditType = repository.save(creditType);
		return mapper.mapToIndividualCreditTypeResponse(creditType);
	}

	@Override
	public IndividualCreditTypeResponse getById(Long id) {
		rules.checkIfExists(id);

		var creditType = repository.findById(id).orElseThrow();
		return mapper.mapToIndividualCreditTypeResponse(creditType);
	}

	@Override
	public PaginatedDataResponse<IndividualCreditTypeResponse> getAllPaged(Pageable pageable) {
		Page<IndividualCreditType> creditTypePage = repository.findAll(pageable);

		List<IndividualCreditTypeResponse> responses = creditTypePage.getContent().stream()
				.map(mapper::mapToIndividualCreditTypeResponse).toList();

		return new PaginatedDataResponse<>(responses, creditTypePage.getNumber(), creditTypePage.getSize(),
				creditTypePage.getTotalPages(), creditTypePage.getTotalElements(), creditTypePage.hasNext(),
				creditTypePage.hasPrevious(), creditTypePage.isFirst(), creditTypePage.isLast());
	}

	@Override
	public IndividualCreditTypeResponse activate(Long id) {
		rules.checkIfExists(id);

		var creditType = repository.findById(id).orElseThrow();
		creditType.setActive(true);
		creditType = repository.save(creditType);
		return mapper.mapToIndividualCreditTypeResponse(creditType);
	}

	@Override
	public IndividualCreditTypeResponse deactivate(Long id) {
		rules.checkIfExists(id);

		var creditType = repository.findById(id).orElseThrow();
		creditType.setActive(false);
		creditType = repository.save(creditType);
		return mapper.mapToIndividualCreditTypeResponse(creditType);
	}

}
