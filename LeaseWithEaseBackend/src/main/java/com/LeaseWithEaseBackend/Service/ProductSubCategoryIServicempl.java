package com.LeaseWithEaseBackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.ProductSubCategory;
import com.LeaseWithEaseBackend.Repository.SubCategoryRepository;

@Service
public class ProductSubCategoryIServicempl implements ProductSubCategoryService {
@Autowired
SubCategoryRepository scRepository; 
	@Override
	public List<ProductSubCategory> getAllSubCategory() {
		return scRepository.findAll();
	}
	@Override
	public ProductSubCategory getSubCategoryById(int psc_id) {
		Optional<ProductSubCategory> psc=scRepository.findById(psc_id);
		return psc.get();
	}
	@Override
	public void addNewSubCategory(ProductSubCategory subcategory) {
     scRepository.save(subcategory);		
	}
	@Override
	public void deleteCategory(int psc_id) {
	scRepository.deleteById(psc_id);	
	}
	
	@Override
	public void updateSCategory(ProductSubCategory psCategory) {
	    ProductSubCategory subcat=getSubCategoryById(psCategory.getPsc_id());
		subcat.setSubCategoryName(psCategory.getSubCategoryName());
		subcat.setImg_url(psCategory.getImg_url());
		subcat.setProductCategory(psCategory.getProductCategory());
		scRepository.save(psCategory);
	}

}
