package com.stock.product.services.impl;

import com.stock.product.io.repository.UsersRepository;
import com.stock.product.shared.dto.UsersDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public String save(UsersVO vO) {
        Users bean = new Users();
        BeanUtils.copyProperties(vO, bean);
        bean = usersRepository.save(bean);
        return bean.getUserName();
    }

    public void delete(String id) {
        usersRepository.deleteById(id);
    }

    public void update(String id, UsersUpdateVO vO) {
        Users bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usersRepository.save(bean);
    }

    public UsersDTO getById(String id) {
        Users original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsersDTO> query(UsersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UsersDTO toDTO(Users original) {
        UsersDTO bean = new UsersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Users requireOne(String id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
