package com.stock.product.services.impl;

import com.stock.product.io.repository.SoldstockRepository;
import com.stock.product.shared.dto.SoldstockDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SoldstockService {

    @Autowired
    private SoldstockRepository soldstockRepository;

    public Integer save(SoldstockVO vO) {
        Soldstock bean = new Soldstock();
        BeanUtils.copyProperties(vO, bean);
        bean = soldstockRepository.save(bean);
        return bean.getSoldStokId();
    }

    public void delete(Integer id) {
        soldstockRepository.deleteById(id);
    }

    public void update(Integer id, SoldstockUpdateVO vO) {
        Soldstock bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        soldstockRepository.save(bean);
    }

    public SoldstockDTO getById(Integer id) {
        Soldstock original = requireOne(id);
        return toDTO(original);
    }

    public Page<SoldstockDTO> query(SoldstockQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SoldstockDTO toDTO(Soldstock original) {
        SoldstockDTO bean = new SoldstockDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Soldstock requireOne(Integer id) {
        return soldstockRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
