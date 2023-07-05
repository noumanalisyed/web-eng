package com.stock.product.services.impl;

import com.stock.product.io.repository.ProductRepository;
import com.stock.product.shared.dto.ProductDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Integer save(ProductVO vO) {
        Product bean = new Product();
        BeanUtils.copyProperties(vO, bean);
        bean = productRepository.save(bean);
        return bean.getProductId();
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public void update(Integer id, ProductUpdateVO vO) {
        Product bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productRepository.save(bean);
    }

    public ProductDTO getById(Integer id) {
        Product original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProductDTO> query(ProductQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ProductDTO toDTO(Product original) {
        ProductDTO bean = new ProductDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Product requireOne(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
