package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
    boolean existsByNationalId(String nationalId);
    boolean existsByEmail(String email);
    IndividualCustomer findByNationalId(String nationalId);
} 