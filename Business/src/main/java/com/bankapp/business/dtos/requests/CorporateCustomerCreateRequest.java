package com.bankapp.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomerCreateRequest {

    @NotBlank(message = "Company name cannot be empty")
    private String companyName;

    @NotBlank(message = "Tax number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Tax number must be 10 digits")
    private String taxNumber;

    private String tradeRegisterNumber;

    private String contactPerson;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Email
    private String email;

    private String address;
} 