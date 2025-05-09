package com.bankapp.core.crosscuttingconcerns.exceptions.handlers;

import com.bankapp.core.crosscuttingconcerns.exceptions.httpproblemdetails.*;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.AuthorizationException;
import com.bankapp.core.crosscuttingconcerns.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HttpExceptionHandler implements com.bankapp.core.crosscuttingconcerns.exceptions.handlers.ExceptionHandler {

    @Override
    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleException(Exception exception) {
        ProblemDetails problemDetails = new InternalServerErrorProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return new ResponseEntity<>(problemDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleBusinessException(BusinessException exception) {
        ProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setDetail("Validation failed");
        problemDetails.setValidationErrors(validationErrors);

        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleAuthorizationException(AuthorizationException exception) {
        ProblemDetails problemDetails = new AuthorizationProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return new ResponseEntity<>(problemDetails, HttpStatus.UNAUTHORIZED);
    }
} 