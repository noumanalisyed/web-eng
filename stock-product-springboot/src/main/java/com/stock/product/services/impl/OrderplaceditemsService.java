package com.stock.product.services.impl;

import com.stock.product.io.repository.OrderplaceditemsRepository;
import com.stock.product.shared.dto.OrderplaceditemsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderplaceditemsService {

    @Autowired
    private OrderplaceditemsRepository orderplaceditemsRepository;

    public Integer save(OrderplaceditemsVO vO) {
        Orderplaceditems bean = new Orderplaceditems();
        BeanUtils.copyProperties(vO, bean);
        bean = orderplaceditemsRepository.save(bean);
        return bean.getOrderPlacedItemsId();
    }

    public void delete(Integer id) {
        orderplaceditemsRepository.deleteById(id);
    }

    public void update(Integer id, OrderplaceditemsUpdateVO vO) {
        Orderplaceditems bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        orderplaceditemsRepository.save(bean);
    }

    public OrderplaceditemsDTO getById(Integer id) {
        Orderplaceditems original = requireOne(id);
        return toDTO(original);
    }

    public Page<OrderplaceditemsDTO> query(OrderplaceditemsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private OrderplaceditemsDTO toDTO(Orderplaceditems original) {
        OrderplaceditemsDTO bean = new OrderplaceditemsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Orderplaceditems requireOne(Integer id) {
        return orderplaceditemsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
