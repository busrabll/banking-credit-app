package com.bankapp.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditTypeResponse {
	
	private Long id;
	private String name;
	private String description;
	private Double minAmount;
	private Double maxAmount;
	private Integer minTerm;
	private Integer maxTerm;
	private Double baseInterestRate;
	private Boolean isActive;

}
