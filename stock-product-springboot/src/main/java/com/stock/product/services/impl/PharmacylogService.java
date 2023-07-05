package com.stock.product.services.impl;

import com.stock.product.io.repository.PharmacylogRepository;
import com.stock.product.shared.dto.PharmacylogDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PharmacylogService {

    @Autowired
    private PharmacylogRepository pharmacylogRepository;

    public Integer save(PharmacylogVO vO) {
        Pharmacylog bean = new Pharmacylog();
        BeanUtils.copyProperties(vO, bean);
        bean = pharmacylogRepository.save(bean);
        return bean.getPharmacyLogId();
    }

    public void delete(Integer id) {
        pharmacylogRepository.deleteById(id);
    }

    public void update(Integer id, PharmacylogUpdateVO vO) {
        Pharmacylog bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        pharmacylogRepository.save(bean);
    }

    public PharmacylogDTO getById(Integer id) {
        Pharmacylog original = requireOne(id);
        return toDTO(original);
    }

    public Page<PharmacylogDTO> query(PharmacylogQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PharmacylogDTO toDTO(Pharmacylog original) {
        PharmacylogDTO bean = new PharmacylogDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Pharmacylog requireOne(Integer id) {
        return pharmacylogRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
