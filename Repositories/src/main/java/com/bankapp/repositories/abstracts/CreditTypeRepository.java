package com.bankapp.repositories.abstracts;

import com.bankapp.entities.model.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository<T extends CreditType> extends JpaRepository<T, Long> {
	boolean existsByName(String name);
}