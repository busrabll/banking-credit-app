package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.IndividualCustomer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer> {

    Optional<IndividualCustomer> findByNationalId(String nationalId);

    boolean existsByNationalId(String nationalId);
} 