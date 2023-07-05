package com.accounting.service;

import com.accounting.domain.entity.AccAccountHead;
import com.accounting.domain.repository.AccAccountHeadRepository;
import com.accounting.shared.dto.AccAccountHeadDTO;
import com.accounting.shared.vo.AccAccountHeadQueryVO;
import com.accounting.shared.vo.AccAccountHeadUpdateVO;
import com.accounting.shared.vo.AccAccountHeadVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccAccountHeadService {

    @Autowired
    private AccAccountHeadRepository accAccountHeadRepository;

    public Long save(AccAccountHeadVO vO) {
        AccAccountHead bean = new AccAccountHead();
        BeanUtils.copyProperties(vO, bean);
        bean = accAccountHeadRepository.save(bean);
        return bean.getAccountId();
    }

    public void delete(Long id) {
        accAccountHeadRepository.deleteById(id);
    }

    public void update(Long id, AccAccountHeadUpdateVO vO) {
        AccAccountHead bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accAccountHeadRepository.save(bean);
    }

    public AccAccountHeadDTO getById(Long id) {
        AccAccountHead original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccAccountHeadDTO> query(AccAccountHeadQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AccAccountHeadDTO toDTO(AccAccountHead original) {
        AccAccountHeadDTO bean = new AccAccountHeadDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AccAccountHead requireOne(Long id) {
        return accAccountHeadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
