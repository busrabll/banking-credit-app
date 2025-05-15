package com.bankapp.business.dtos.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorporateCreditTypeCreateRequest {
	
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
	private Double minRevenue;
	
	private Integer minCompanyAge;
	
	private Boolean requiresCollateral = false;


}
