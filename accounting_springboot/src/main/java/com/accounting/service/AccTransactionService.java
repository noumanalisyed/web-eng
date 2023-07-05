package com.accounting.service;

import com.accounting.domain.entity.AccTransaction;
import com.accounting.domain.repository.AccTransactionRepository;
import com.accounting.shared.dto.AccTransactionDTO;
import com.accounting.shared.vo.AccTransactionQueryVO;
import com.accounting.shared.vo.AccTransactionUpdateVO;
import com.accounting.shared.vo.AccTransactionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccTransactionService {

    @Autowired
    private AccTransactionRepository accTransactionRepository;

    public Long save(AccTransactionVO vO) {
        AccTransaction bean = new AccTransaction();
        BeanUtils.copyProperties(vO, bean);
        bean = accTransactionRepository.save(bean);
        return bean.getTransactionId();
    }

    public void delete(Long id) {
        accTransactionRepository.deleteById(id);
    }

    public void update(Long id, AccTransactionUpdateVO vO) {
        AccTransaction bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accTransactionRepository.save(bean);
    }

    public AccTransactionDTO getById(Long id) {
        AccTransaction original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccTransactionDTO> query(AccTransactionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AccTransactionDTO toDTO(AccTransaction original) {
        AccTransactionDTO bean = new AccTransactionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AccTransaction requireOne(Long id) {
        return accTransactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
