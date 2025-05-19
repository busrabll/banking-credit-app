package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.auth.LoginRequest;
import com.bankapp.business.dtos.requests.auth.RegisterIndividualRequest;
import com.bankapp.business.dtos.responses.auth.AuthResponse;

public interface AuthService {

	AuthResponse registerIndividual(RegisterIndividualRequest request);
	AuthResponse login(LoginRequest request);
	
}
