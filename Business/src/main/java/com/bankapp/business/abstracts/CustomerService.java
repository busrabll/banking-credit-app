package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.responses.CustomerResponse;

public interface CustomerService<T extends CustomerResponse> {
    // Ortak dönüşüm işlemleri
    T formatResponse(T response);
    String formatPhoneNumber(String phoneNumber);
    String formatAddress(String address);
} 