package com.stock.product.services.impl;

import com.stock.product.io.repository.OrderstatusRepository;
import com.stock.product.shared.dto.OrderstatusDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderstatusService {

    @Autowired
    private OrderstatusRepository orderstatusRepository;

    public Integer save(OrderstatusVO vO) {
        Orderstatus bean = new Orderstatus();
        BeanUtils.copyProperties(vO, bean);
        bean = orderstatusRepository.save(bean);
        return bean.getOrderStatusId();
    }

    public void delete(Integer id) {
        orderstatusRepository.deleteById(id);
    }

    public void update(Integer id, OrderstatusUpdateVO vO) {
        Orderstatus bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        orderstatusRepository.save(bean);
    }

    public OrderstatusDTO getById(Integer id) {
        Orderstatus original = requireOne(id);
        return toDTO(original);
    }

    public Page<OrderstatusDTO> query(OrderstatusQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private OrderstatusDTO toDTO(Orderstatus original) {
        OrderstatusDTO bean = new OrderstatusDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Orderstatus requireOne(Integer id) {
        return orderstatusRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
