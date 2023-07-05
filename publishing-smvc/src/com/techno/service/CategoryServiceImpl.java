package com.techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techno.bean.CategoryBean;
import com.techno.dao.CategoryDao;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCategory(CategoryBean categoryBean) {
		categoryDao.addCategory(categoryBean);
	}

	@Override
	public List<CategoryBean> getCategories() {
		return categoryDao.getCategories();
	}

	@Override
	public CategoryBean getCategory(int categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryDao.deleteCategory(categoryId);
	}

}
