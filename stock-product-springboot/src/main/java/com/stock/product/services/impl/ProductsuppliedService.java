package com.stock.product.services.impl;

import com.stock.product.io.repository.ProductsuppliedRepository;
import com.stock.product.shared.dto.ProductsuppliedDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductsuppliedService {

    @Autowired
    private ProductsuppliedRepository productsuppliedRepository;

    public Integer save(ProductsuppliedVO vO) {
        Productsupplied bean = new Productsupplied();
        BeanUtils.copyProperties(vO, bean);
        bean = productsuppliedRepository.save(bean);
        return bean.getProductSuppliedId();
    }

    public void delete(Integer id) {
        productsuppliedRepository.deleteById(id);
    }

    public void update(Integer id, ProductsuppliedUpdateVO vO) {
        Productsupplied bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productsuppliedRepository.save(bean);
    }

    public ProductsuppliedDTO getById(Integer id) {
        Productsupplied original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProductsuppliedDTO> query(ProductsuppliedQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ProductsuppliedDTO toDTO(Productsupplied original) {
        ProductsuppliedDTO bean = new ProductsuppliedDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Productsupplied requireOne(Integer id) {
        return productsuppliedRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
