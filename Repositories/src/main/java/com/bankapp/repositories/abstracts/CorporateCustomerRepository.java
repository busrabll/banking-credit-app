package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.CorporateCustomer;
import org.springframework.stereotype.Repository;


@Repository
public interface CorporateCustomerRepository extends CustomerRepository<CorporateCustomer> {

    boolean existsByTaxNumber(String taxNumber);
    CorporateCustomer findByTaxNumber(String taxNumber);
} 