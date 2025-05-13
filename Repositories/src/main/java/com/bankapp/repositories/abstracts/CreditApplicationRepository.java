package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.CreditApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    Page<CreditApplication> findAllByCustomerId(Long customer, Pageable pageable);
} 