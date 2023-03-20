package com.LeaseWithEaseBackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.ProductCategory;
import com.LeaseWithEaseBackend.Repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	ProductCategoryRepository pcRepository;
	@Override
	public List<ProductCategory> getAllCategory() {
		return pcRepository.findAll();
	}
	@Override
	public ProductCategory getCategoryById(int pc_id) {
		Optional<ProductCategory> pcat=pcRepository.findById(pc_id);
		return pcat.get();
	}
	@Override
	public void addNewCategory(ProductCategory category) {
		pcRepository.save(category);		
	}
	@Override
	public void deleteCtaegory(int pc_id) {
		pcRepository.deleteById(pc_id);
	}

}
