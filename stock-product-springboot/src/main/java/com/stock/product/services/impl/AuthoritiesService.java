package com.stock.product.services.impl;

import com.stock.product.io.repository.AuthoritiesRepository;
import com.stock.product.shared.dto.AuthoritiesDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthoritiesService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public Integer save(AuthoritiesVO vO) {
        Authorities bean = new Authorities();
        BeanUtils.copyProperties(vO, bean);
        bean = authoritiesRepository.save(bean);
        return bean.getAuthorityId();
    }

    public void delete(Integer id) {
        authoritiesRepository.deleteById(id);
    }

    public void update(Integer id, AuthoritiesUpdateVO vO) {
        Authorities bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        authoritiesRepository.save(bean);
    }

    public AuthoritiesDTO getById(Integer id) {
        Authorities original = requireOne(id);
        return toDTO(original);
    }

    public Page<AuthoritiesDTO> query(AuthoritiesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AuthoritiesDTO toDTO(Authorities original) {
        AuthoritiesDTO bean = new AuthoritiesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Authorities requireOne(Integer id) {
        return authoritiesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
