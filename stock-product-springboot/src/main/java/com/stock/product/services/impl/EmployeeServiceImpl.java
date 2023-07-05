package com.stock.product.services.impl;

import com.stock.product.io.repository.EmployeeRepository;
import com.stock.product.shared.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Integer save(EmployeeVO vO) {
        Employee bean = new Employee();
        BeanUtils.copyProperties(vO, bean);
        bean = employeeRepository.save(bean);
        return bean.getEmpId();
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void update(Integer id, EmployeeUpdateVO vO) {
        Employee bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        employeeRepository.save(bean);
    }

    public EmployeeDTO getById(Integer id) {
        Employee original = requireOne(id);
        return toDTO(original);
    }

    public Page<EmployeeDTO> query(EmployeeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EmployeeDTO toDTO(Employee original) {
        EmployeeDTO bean = new EmployeeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Employee requireOne(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
