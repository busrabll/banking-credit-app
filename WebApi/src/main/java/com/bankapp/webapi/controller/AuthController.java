package com.bankapp.webapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.business.abstracts.AuthService;
import com.bankapp.business.dtos.requests.auth.LoginRequest;
import com.bankapp.business.dtos.requests.auth.RegisterIndividualRequest;
import com.bankapp.business.dtos.responses.auth.AuthResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Tag(name = "Authentication", description= "Authentication Management APIs")
public class AuthController {
	
	private AuthService authService;
	
	@PostMapping("/register/individual")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Register a new individual customer")
	public AuthResponse registerIndividual(@Valid @RequestBody RegisterIndividualRequest request) {
		return authService.registerIndividual(request);
	}
	
	@PostMapping("/login")
	@Operation(summary = "Login")
	public AuthResponse login(@Valid @RequestBody LoginRequest request) {
		return authService.login(request);
	}

}
