package com.bankapp.core.crosscuttingconcerns.exceptions.types;

public class AuthorizationException extends RuntimeException {
    
    public AuthorizationException(String message) {
        super(message);
    }
} 