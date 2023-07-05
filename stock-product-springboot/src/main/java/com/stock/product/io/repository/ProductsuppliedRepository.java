package com.stock.product.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsuppliedRepository extends JpaRepository<Productsupplied, Integer>, JpaSpecificationExecutor<Productsupplied> {

}
