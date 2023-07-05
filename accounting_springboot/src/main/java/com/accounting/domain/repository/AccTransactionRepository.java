package com.accounting.domain.repository;

import com.accounting.domain.entity.AccTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccTransactionRepository extends JpaRepository<AccTransaction, Long>, JpaSpecificationExecutor<AccTransaction> {

}
