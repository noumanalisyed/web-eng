package com.stock.product.services.impl;

import com.stock.product.io.repository.SolditemsRepository;
import com.stock.product.shared.dto.SolditemsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SolditemsService {

    @Autowired
    private SolditemsRepository solditemsRepository;

    public Integer save(SolditemsVO vO) {
        Solditems bean = new Solditems();
        BeanUtils.copyProperties(vO, bean);
        bean = solditemsRepository.save(bean);
        return bean.getSoldItemId();
    }

    public void delete(Integer id) {
        solditemsRepository.deleteById(id);
    }

    public void update(Integer id, SolditemsUpdateVO vO) {
        Solditems bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        solditemsRepository.save(bean);
    }

    public SolditemsDTO getById(Integer id) {
        Solditems original = requireOne(id);
        return toDTO(original);
    }

    public Page<SolditemsDTO> query(SolditemsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SolditemsDTO toDTO(Solditems original) {
        SolditemsDTO bean = new SolditemsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Solditems requireOne(Integer id) {
        return solditemsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
