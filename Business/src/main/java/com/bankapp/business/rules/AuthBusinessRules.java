package com.bankapp.business.rules;

import org.springframework.stereotype.Service;

import com.bankapp.business.constants.Messages;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.bankapp.repositories.abstracts.UserRepository;
import com.bankapp.repositories.abstracts.IndividualCustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthBusinessRules {

	private UserRepository userRepository;
	private IndividualCustomerRepository individualCustomerRepository;

	public void checkIfUserNameExists(String username) {
		if (userRepository.existsByUsername(username)) {
			throw new BusinessException(Messages.User.USERNAME_ALREADY_EXISTS);
		}
	}

	public void checkIfEmailExists(String email) {
		if (userRepository.existsByEmail(email)) {
			throw new BusinessException(Messages.Customer.EMAIL_ALREADY_EXISTS);
		}
	}

	public void checkIfNationalIdExists(String nationalId) {
		if (individualCustomerRepository.existsByNationalId(nationalId)) {
			throw new BusinessException(Messages.Customer.INDIVIDUAL_CUSTOMER_ALREADY_EXISTS);
		}
	}
}
