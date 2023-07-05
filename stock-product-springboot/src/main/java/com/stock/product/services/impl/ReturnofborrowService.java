package com.stock.product.services.impl;

import com.stock.product.io.repository.ReturnofborrowRepository;
import com.stock.product.shared.dto.ReturnofborrowDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ReturnofborrowService {

    @Autowired
    private ReturnofborrowRepository returnofborrowRepository;

    public Integer save(ReturnofborrowVO vO) {
        Returnofborrow bean = new Returnofborrow();
        BeanUtils.copyProperties(vO, bean);
        bean = returnofborrowRepository.save(bean);
        return bean.getReturnOfBorrowId();
    }

    public void delete(Integer id) {
        returnofborrowRepository.deleteById(id);
    }

    public void update(Integer id, ReturnofborrowUpdateVO vO) {
        Returnofborrow bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        returnofborrowRepository.save(bean);
    }

    public ReturnofborrowDTO getById(Integer id) {
        Returnofborrow original = requireOne(id);
        return toDTO(original);
    }

    public Page<ReturnofborrowDTO> query(ReturnofborrowQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ReturnofborrowDTO toDTO(Returnofborrow original) {
        ReturnofborrowDTO bean = new ReturnofborrowDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Returnofborrow requireOne(Integer id) {
        return returnofborrowRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
