package com.stock.product.services.impl;

import com.stock.product.io.repository.SupplierRepository;
import com.stock.product.shared.dto.SupplierDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Integer save(SupplierVO vO) {
        Supplier bean = new Supplier();
        BeanUtils.copyProperties(vO, bean);
        bean = supplierRepository.save(bean);
        return bean.getSupplierId();
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }

    public void update(Integer id, SupplierUpdateVO vO) {
        Supplier bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        supplierRepository.save(bean);
    }

    public SupplierDTO getById(Integer id) {
        Supplier original = requireOne(id);
        return toDTO(original);
    }

    public Page<SupplierDTO> query(SupplierQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SupplierDTO toDTO(Supplier original) {
        SupplierDTO bean = new SupplierDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Supplier requireOne(Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
