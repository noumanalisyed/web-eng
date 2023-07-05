package com.accounting.domain.repository;

import com.accounting.domain.entity.AccVoucherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccVoucherTypeRepository extends JpaRepository<AccVoucherType, Integer>, JpaSpecificationExecutor<AccVoucherType> {

}
