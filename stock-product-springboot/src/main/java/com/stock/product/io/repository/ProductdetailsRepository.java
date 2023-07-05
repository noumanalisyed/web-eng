package com.stock.product.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductdetailsRepository extends JpaRepository<Productdetails, Integer>, JpaSpecificationExecutor<Productdetails> {

}
