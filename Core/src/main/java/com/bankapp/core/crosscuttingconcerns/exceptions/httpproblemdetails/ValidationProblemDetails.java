package com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> validationErrors;

    public ValidationProblemDetails() {
        setTitle("Validation Error");
        setType("https://bankapp.com/validation-error");
        setStatus(HttpStatus.BAD_REQUEST.value());
    }
} 