package com.stock.product.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymenttypeRepository extends JpaRepository<Paymenttype, Integer>, JpaSpecificationExecutor<Paymenttype> {

}
