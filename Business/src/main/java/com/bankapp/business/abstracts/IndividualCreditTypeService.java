package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.IndividualCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCreditTypeResponse;

public interface IndividualCreditTypeService extends CreditTypeService<IndividualCreditTypeResponse, IndividualCreditTypeCreateRequest> {

}
