package com.accounting.service;

import com.accounting.domain.entity.AccTransactionDetail;
import com.accounting.domain.repository.AccTransactionDetailRepository;
import com.accounting.shared.dto.AccTransactionDetailDTO;
import com.accounting.shared.vo.AccTransactionDetailQueryVO;
import com.accounting.shared.vo.AccTransactionDetailUpdateVO;
import com.accounting.shared.vo.AccTransactionDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccTransactionDetailService {

    @Autowired
    private AccTransactionDetailRepository accTransactionDetailRepository;

    public Long save(AccTransactionDetailVO vO) {
        AccTransactionDetail bean = new AccTransactionDetail();
        BeanUtils.copyProperties(vO, bean);
        bean = accTransactionDetailRepository.save(bean);
        return bean.getTransactionDetailId();
    }

    public void delete(Long id) {
        accTransactionDetailRepository.deleteById(id);
    }

    public void update(Long id, AccTransactionDetailUpdateVO vO) {
        AccTransactionDetail bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accTransactionDetailRepository.save(bean);
    }

    public AccTransactionDetailDTO getById(Long id) {
        AccTransactionDetail original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccTransactionDetailDTO> query(AccTransactionDetailQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AccTransactionDetailDTO toDTO(AccTransactionDetail original) {
        AccTransactionDetailDTO bean = new AccTransactionDetailDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AccTransactionDetail requireOne(Long id) {
        return accTransactionDetailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
