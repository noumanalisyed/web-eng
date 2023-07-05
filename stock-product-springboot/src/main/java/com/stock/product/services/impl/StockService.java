package com.stock.product.services.impl;

import com.stock.product.io.repository.StockRepository;
import com.stock.product.shared.dto.StockDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Integer save(StockVO vO) {
        Stock bean = new Stock();
        BeanUtils.copyProperties(vO, bean);
        bean = stockRepository.save(bean);
        return bean.getStockId();
    }

    public void delete(Integer id) {
        stockRepository.deleteById(id);
    }

    public void update(Integer id, StockUpdateVO vO) {
        Stock bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        stockRepository.save(bean);
    }

    public StockDTO getById(Integer id) {
        Stock original = requireOne(id);
        return toDTO(original);
    }

    public Page<StockDTO> query(StockQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private StockDTO toDTO(Stock original) {
        StockDTO bean = new StockDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Stock requireOne(Integer id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
