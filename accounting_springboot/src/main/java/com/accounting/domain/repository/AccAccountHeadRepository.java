package com.accounting.domain.repository;

import com.accounting.domain.entity.AccAccountHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccAccountHeadRepository extends JpaRepository<AccAccountHead, Long>, JpaSpecificationExecutor<AccAccountHead> {

}
