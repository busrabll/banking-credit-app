package com.bankapp.core.crosscuttingconcerns.exceptions.handlers;

import com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails.ProblemDetails;
import org.springframework.http.ResponseEntity;

public interface ExceptionHandler {
    ResponseEntity<ProblemDetails> handleException(Exception exception);
} 