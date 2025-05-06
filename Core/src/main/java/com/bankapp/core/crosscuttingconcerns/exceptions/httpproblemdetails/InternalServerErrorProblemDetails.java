package com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails;

import org.springframework.http.HttpStatus;


public class InternalServerErrorProblemDetails extends ProblemDetails {

    public InternalServerErrorProblemDetails() {
        setTitle("Internal Server Error");
        setType("https://bankapp.com/internal-server-error");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
} 