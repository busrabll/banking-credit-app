package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Long> {

    @Query("SELECT c FROM #{#entityName} c WHERE c.customerNumber = :customerNumber AND c.isDeleted = false")
    Optional<T> findByCustomerNumber(String customerNumber);

    @Query("SELECT c FROM #{#entityName} c WHERE c.email = :email AND c.isDeleted = false")
    Optional<T> findByEmail(String email);

    @Query("SELECT c FROM #{#entityName} c WHERE c.id = :id AND c.isDeleted = false")
    Optional<T> findById(Long id);

    @Query("UPDATE #{#entityName} c SET c.isDeleted = true, c.deletedDate = CURRENT_TIMESTAMP WHERE c.id = :id")
    void softDelete(Long id);
} 