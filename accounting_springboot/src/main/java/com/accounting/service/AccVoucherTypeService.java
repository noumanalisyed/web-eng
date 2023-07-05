package com.accounting.service;

import com.accounting.domain.entity.AccVoucherType;
import com.accounting.domain.repository.AccVoucherTypeRepository;
import com.accounting.shared.dto.AccVoucherTypeDTO;
import com.accounting.shared.vo.AccVoucherTypeQueryVO;
import com.accounting.shared.vo.AccVoucherTypeUpdateVO;
import com.accounting.shared.vo.AccVoucherTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccVoucherTypeService {

    @Autowired
    private AccVoucherTypeRepository accVoucherTypeRepository;

    public Integer save(AccVoucherTypeVO vO) {
        AccVoucherType bean = new AccVoucherType();
        BeanUtils.copyProperties(vO, bean);
        bean = accVoucherTypeRepository.save(bean);
        return bean.getVoucherTypeId();
    }

    public void delete(Integer id) {
        accVoucherTypeRepository.deleteById(id);
    }

    public void update(Integer id, AccVoucherTypeUpdateVO vO) {
        AccVoucherType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accVoucherTypeRepository.save(bean);
    }

    public AccVoucherTypeDTO getById(Integer id) {
        AccVoucherType original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccVoucherTypeDTO> query(AccVoucherTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AccVoucherTypeDTO toDTO(AccVoucherType original) {
        AccVoucherTypeDTO bean = new AccVoucherTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AccVoucherType requireOne(Integer id) {
        return accVoucherTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
