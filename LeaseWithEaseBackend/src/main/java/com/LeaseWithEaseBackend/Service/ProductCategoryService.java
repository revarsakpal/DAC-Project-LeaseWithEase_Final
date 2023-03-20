package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.ProductCategory;

public interface ProductCategoryService {

	List<ProductCategory> getAllCategory();

	ProductCategory getCategoryById(int pc_id);

	void addNewCategory(ProductCategory category);

	void deleteCtaegory(int pc_id);

}
