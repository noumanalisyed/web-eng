package com.stock.product.services;

import com.stock.product.shared.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;

import java.util.NoSuchElementException;

public interface EmployeeService {
    public Integer save(EmployeeVO vO) ;

    public void delete(Integer id) ;

    public void update(Integer id, EmployeeUpdateVO vO) ;

    public EmployeeDTO getById(Integer id) ;

    public Page<EmployeeDTO> query(EmployeeQueryVO vO);

    private EmployeeDTO toDTO(Employee original);

    private Employee requireOne(Integer id);
}
