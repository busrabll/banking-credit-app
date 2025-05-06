package com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails;

import org.springframework.http.HttpStatus;


public class AuthorizationProblemDetails extends ProblemDetails {

    public AuthorizationProblemDetails() {
        setTitle("Authorization Error");
        setType("https://bankapp.com/authorization-error");
        setStatus(HttpStatus.UNAUTHORIZED.value());
    }
} 