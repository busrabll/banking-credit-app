package com.bankapp.business.rules;

import org.springframework.stereotype.Service;

import com.bankapp.business.constants.Messages;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.entities.model.CreditType;
import com.bankapp.repositories.abstracts.CreditTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditTypeBusinessRules {

	private CreditTypeRepository<CreditType> repository;

	public void checkIfExists(Long id) {
		if (!repository.existsById(id)) {
			throw new BusinessException(Messages.Credit.CREDIT_TYPE_NOT_FOUND);
		}
	}

	public void checkIfNameExists(String name) {
		if (repository.existsByName(name)) {
			throw new BusinessException(Messages.Credit.CREDİT_TYPE_NAME_EXISTS);
		}
	}

	public void checkIfAmountRangeValid(Double minAmount, Double maxAmount) {
		if (minAmount >= maxAmount) {
			throw new BusinessException(Messages.Credit.AMOUNT_OUT_OF_RANGE);
		}
	}

	public void checkIfTermRangeValid(Integer minTerm, Integer maxTerm) {
		if (minTerm > maxTerm) {
			throw new BusinessException(Messages.Credit.TERM_OUT_OF_RANGE);
		}
	}
}
