package com.bankapp.repositories.abstracts;

import org.springframework.stereotype.Repository;

import com.bankapp.entities.model.IndividualCreditType;

@Repository
public interface IndividualCreditTypeRepository extends CreditTypeRepository<IndividualCreditType> {

}
