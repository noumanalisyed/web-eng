package com.stock.product.services.impl;

import com.stock.product.io.repository.CategoryRepository;
import com.stock.product.shared.dto.CategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Integer save(CategoryVO vO) {
        Category bean = new Category();
        BeanUtils.copyProperties(vO, bean);
        bean = categoryRepository.save(bean);
        return bean.getCategoryId();
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void update(Integer id, CategoryUpdateVO vO) {
        Category bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        categoryRepository.save(bean);
    }

    public CategoryDTO getById(Integer id) {
        Category original = requireOne(id);
        return toDTO(original);
    }

    public Page<CategoryDTO> query(CategoryQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CategoryDTO toDTO(Category original) {
        CategoryDTO bean = new CategoryDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Category requireOne(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
