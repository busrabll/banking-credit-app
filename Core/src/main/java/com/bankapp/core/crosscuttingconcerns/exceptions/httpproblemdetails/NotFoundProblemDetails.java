package com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails;


import org.springframework.http.HttpStatus;

public class NotFoundProblemDetails extends ProblemDetails {

    public NotFoundProblemDetails() {
        setTitle("Resource Not Found");
        setType("https://bankapp.com/not-found-error");
        setStatus(HttpStatus.NOT_FOUND.value());
    }
} 