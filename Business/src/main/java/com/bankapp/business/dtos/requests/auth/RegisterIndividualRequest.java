package com.bankapp.business.dtos.requests.auth;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterIndividualRequest {
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{11}$", message = "National id must be 11 digits")
	private String nationalId;
	
	private LocalDate birthDate;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
	private String phoneNumber;
	
	private String address;

}
