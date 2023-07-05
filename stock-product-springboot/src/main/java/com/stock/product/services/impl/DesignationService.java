package com.stock.product.services.impl;

import com.stock.product.io.repository.DesignationRepository;
import com.stock.product.shared.dto.DesignationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    public Integer save(DesignationVO vO) {
        Designation bean = new Designation();
        BeanUtils.copyProperties(vO, bean);
        bean = designationRepository.save(bean);
        return bean.getDesignationId();
    }

    public void delete(Integer id) {
        designationRepository.deleteById(id);
    }

    public void update(Integer id, DesignationUpdateVO vO) {
        Designation bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        designationRepository.save(bean);
    }

    public DesignationDTO getById(Integer id) {
        Designation original = requireOne(id);
        return toDTO(original);
    }

    public Page<DesignationDTO> query(DesignationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DesignationDTO toDTO(Designation original) {
        DesignationDTO bean = new DesignationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Designation requireOne(Integer id) {
        return designationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
