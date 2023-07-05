package com.techno.dao;

import java.util.List;

import com.techno.bean.CategoryBean;

public interface CategoryDao {
	
	public void addCategory(CategoryBean categoryBean);
	
	public List<CategoryBean> getCategories();
	
	public CategoryBean getCategory(int categoryId);
	
	public void deleteCategory(int categoryId);
}
