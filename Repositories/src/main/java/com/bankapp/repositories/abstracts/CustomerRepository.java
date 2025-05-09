package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Long> {

    boolean existsByCustomerNumber(String customerNumber);
    T findByCustomerNumber(String customerNumber);
} 