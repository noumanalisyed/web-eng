package com.stock.product.services.impl;

import com.stock.product.io.repository.SalesRepository;
import com.stock.product.shared.dto.SalesDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public Integer save(SalesVO vO) {
        Sales bean = new Sales();
        BeanUtils.copyProperties(vO, bean);
        bean = salesRepository.save(bean);
        return bean.getSalesId();
    }

    public void delete(Integer id) {
        salesRepository.deleteById(id);
    }

    public void update(Integer id, SalesUpdateVO vO) {
        Sales bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        salesRepository.save(bean);
    }

    public SalesDTO getById(Integer id) {
        Sales original = requireOne(id);
        return toDTO(original);
    }

    public Page<SalesDTO> query(SalesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SalesDTO toDTO(Sales original) {
        SalesDTO bean = new SalesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Sales requireOne(Integer id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
