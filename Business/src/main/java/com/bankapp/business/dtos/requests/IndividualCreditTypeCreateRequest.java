package com.bankapp.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IndividualCreditTypeCreateRequest {
	
	@NotBlank
	private String name;
	
	private String description;
	
	@NotNull
	@Min(1)
	private Double minAmount;
	
	@NotNull
	@Min(1)
	private Double maxAmount;
	
	@NotNull
	@Min(1)
	private Integer minTerm;
	
	@NotNull
	@Min(1)
	private Integer maxTerm;
	
	@NotNull
	@DecimalMin("0.01")
	private Double baseInterestRate;
	
	@NotNull
	@Min(1)
	private Integer minCreditScore;
	
	private Boolean requiresGuarantor = false;

}
