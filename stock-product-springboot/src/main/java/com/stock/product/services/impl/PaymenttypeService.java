package com.stock.product.services.impl;

import com.stock.product.io.repository.PaymenttypeRepository;
import com.stock.product.shared.dto.PaymenttypeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaymenttypeService {

    @Autowired
    private PaymenttypeRepository paymenttypeRepository;

    public Integer save(PaymenttypeVO vO) {
        Paymenttype bean = new Paymenttype();
        BeanUtils.copyProperties(vO, bean);
        bean = paymenttypeRepository.save(bean);
        return bean.getPaymentTypeId();
    }

    public void delete(Integer id) {
        paymenttypeRepository.deleteById(id);
    }

    public void update(Integer id, PaymenttypeUpdateVO vO) {
        Paymenttype bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paymenttypeRepository.save(bean);
    }

    public PaymenttypeDTO getById(Integer id) {
        Paymenttype original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaymenttypeDTO> query(PaymenttypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaymenttypeDTO toDTO(Paymenttype original) {
        PaymenttypeDTO bean = new PaymenttypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Paymenttype requireOne(Integer id) {
        return paymenttypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
