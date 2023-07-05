package com.stock.product.services.impl;

import com.stock.product.io.repository.ProductdetailsRepository;
import com.stock.product.shared.dto.ProductdetailsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductdetailsService {

    @Autowired
    private ProductdetailsRepository productdetailsRepository;

    public Integer save(ProductdetailsVO vO) {
        Productdetails bean = new Productdetails();
        BeanUtils.copyProperties(vO, bean);
        bean = productdetailsRepository.save(bean);
        return bean.getProductDetailId();
    }

    public void delete(Integer id) {
        productdetailsRepository.deleteById(id);
    }

    public void update(Integer id, ProductdetailsUpdateVO vO) {
        Productdetails bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productdetailsRepository.save(bean);
    }

    public ProductdetailsDTO getById(Integer id) {
        Productdetails original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProductdetailsDTO> query(ProductdetailsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ProductdetailsDTO toDTO(Productdetails original) {
        ProductdetailsDTO bean = new ProductdetailsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Productdetails requireOne(Integer id) {
        return productdetailsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
