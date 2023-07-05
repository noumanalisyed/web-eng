package com.accounting.domain.repository;

import com.accounting.domain.entity.AccTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccTransactionDetailRepository extends JpaRepository<AccTransactionDetail, Long>, JpaSpecificationExecutor<AccTransactionDetail> {

}
