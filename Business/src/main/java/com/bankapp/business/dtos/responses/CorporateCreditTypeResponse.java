package com.bankapp.business.dtos.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CorporateCreditTypeResponse extends CreditTypeResponse {

	private Double minRevenue;
	private Integer minCompanyAge;
	private Boolean requiresCollateral;
}
