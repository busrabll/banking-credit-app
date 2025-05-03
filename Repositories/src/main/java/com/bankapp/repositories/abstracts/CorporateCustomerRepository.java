package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.CorporateCustomer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorporateCustomerRepository extends CustomerRepository<CorporateCustomer> {

    Optional<CorporateCustomer> findByTaxNumber(String taxNumber);

    Optional<CorporateCustomer> findByCompanyRegistrationNumber(String companyRegistrationNumber);

    boolean existsByTaxNumber(String taxNumber);

    boolean existsByCompanyRegistrationNumber(String companyRegistrationNumber);
} 