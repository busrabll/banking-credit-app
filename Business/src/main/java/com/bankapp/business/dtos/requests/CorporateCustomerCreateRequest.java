package com.bankapp.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomerCreateRequest {
    @NotBlank(message = "Company name cannot be empty")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    private String companyName;

    @NotBlank(message = "Tax number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Tax number must be 10 digits")
    private String taxNumber;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email format is invalid")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String address;
} 