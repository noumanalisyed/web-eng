package com.stock.product.services.impl;

import com.stock.product.io.repository.OrderRepository;
import com.stock.product.shared.dto.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Integer save(OrderVO vO) {
        Order bean = new Order();
        BeanUtils.copyProperties(vO, bean);
        bean = orderRepository.save(bean);
        return bean.getOrderId();
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    public void update(Integer id, OrderUpdateVO vO) {
        Order bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        orderRepository.save(bean);
    }

    public OrderDTO getById(Integer id) {
        Order original = requireOne(id);
        return toDTO(original);
    }

    public Page<OrderDTO> query(OrderQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private OrderDTO toDTO(Order original) {
        OrderDTO bean = new OrderDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Order requireOne(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
