package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.ProductSubCategory;

public interface ProductSubCategoryService {

	List<ProductSubCategory> getAllSubCategory();

	ProductSubCategory getSubCategoryById(int psc_id);

	void addNewSubCategory(ProductSubCategory subcategory);

	void deleteCategory(int psc_id);

	void updateSCategory(ProductSubCategory psCategory);

}
