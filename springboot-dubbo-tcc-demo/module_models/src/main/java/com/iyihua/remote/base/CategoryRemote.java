package com.iyihua.remote.base;

import java.util.List;

import com.iyihua.model.base.CategoryDTO;

public interface CategoryRemote {

	public List<CategoryDTO> findCategorysByUserId(Long userId);
	
	public CategoryDTO saveCategory(CategoryDTO category);
	
	public void deleteCategory(Long categoryId);
}
