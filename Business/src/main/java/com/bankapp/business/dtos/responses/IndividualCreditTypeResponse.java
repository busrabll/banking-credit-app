package com.bankapp.business.dtos.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualCreditTypeResponse extends CreditTypeResponse {
	
	private Integer minCreditScore;
	private Boolean requiresGuarantor;

}
