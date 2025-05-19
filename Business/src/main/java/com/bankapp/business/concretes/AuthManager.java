package com.bankapp.business.concretes;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankapp.business.abstracts.AuthService;
import com.bankapp.business.dtos.requests.auth.LoginRequest;
import com.bankapp.business.dtos.requests.auth.RegisterIndividualRequest;
import com.bankapp.business.dtos.responses.auth.AuthResponse;
import com.bankapp.business.rules.AuthBusinessRules;
import com.bankapp.core.security.JwtService;
import com.bankapp.entities.enums.Role;
import com.bankapp.entities.model.IndividualCustomer;
import com.bankapp.entities.model.User;
import com.bankapp.repositories.abstracts.IndividualCustomerRepository;
import com.bankapp.repositories.abstracts.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

	private UserRepository userRepository;
	private IndividualCustomerRepository individualCustomerRepository;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	private AuthBusinessRules rules;

	@Override
	@Transactional
	public AuthResponse registerIndividual(RegisterIndividualRequest request) {

		rules.checkIfUserNameExists(request.getUsername());
		rules.checkIfEmailExists(request.getEmail());
		rules.checkIfNationalIdExists(request.getNationalId());

		var customer = new IndividualCustomer();

		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setNationalId(request.getNationalId());
		customer.setBirthDate(request.getBirthDate());
		customer.setPhoneNumber(request.getPhoneNumber());
		customer.setEmail(request.getEmail());
		customer.setAddress(request.getAddress());

		customer = individualCustomerRepository.save(customer);

		var user = new User();

		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setEmail(request.getEmail());
		user.setRole(Role.INDIVIDUAL_CUSTOMER);
		user.setCustomer(customer);

		userRepository.save(user);

		var token = jwtService.generateToken(user);
		return AuthResponse.builder().token(token).build();

	}

	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(), 
						request.getPassword()
				)
		);
		
		var user = userRepository.findByUsername(request.getUsername())
				.orElseThrow();
		
		var token = jwtService.generateToken(user);
		return AuthResponse.builder().token(token).build();
	}

}
