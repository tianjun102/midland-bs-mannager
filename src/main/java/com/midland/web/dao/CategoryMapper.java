package com.midland.web.dao;

import com.midland.web.model.Category;
import java.util.List;

public interface CategoryMapper {

	Category selectCategoryById(Integer category);

	int deleteCategoryById(Integer category);

	int updateCategoryById(Category category);

	int insertCategory(Category category);

	List<Category> findCategoryList(Category category);

}
