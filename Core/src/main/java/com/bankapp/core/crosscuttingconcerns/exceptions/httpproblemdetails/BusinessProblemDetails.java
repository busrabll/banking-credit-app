package com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails;

import org.springframework.http.HttpStatus;


public class BusinessProblemDetails extends ProblemDetails {

    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setType("https://bankapp.com/business-error");
        setStatus(HttpStatus.BAD_REQUEST.value());
    }
} 