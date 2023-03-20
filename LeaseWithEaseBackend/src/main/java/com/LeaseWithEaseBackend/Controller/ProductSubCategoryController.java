package com.LeaseWithEaseBackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LeaseWithEaseBackend.Model.ProductCategory;
import com.LeaseWithEaseBackend.Model.ProductSubCategory;
import com.LeaseWithEaseBackend.Service.ProductCategoryService;
import com.LeaseWithEaseBackend.Service.ProductSubCategoryService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductSubCategoryController {
	@Autowired
	ProductSubCategoryService pscService;
	
	
	@GetMapping("subcategories")
	public List<ProductSubCategory> getAllSubCategory() {
		List<ProductSubCategory> pscList=pscService.getAllSubCategory();
		return pscList;
	}
	@GetMapping("subcategories/{psc_id}")
	public ProductSubCategory getSubCategoryById(@PathVariable int psc_id) {
		ProductSubCategory psubcat=pscService.getSubCategoryById(psc_id);
		return psubcat;
	}
	
	@PostMapping("subcategories/addNew/{pc_id}")
	public ResponseEntity<String> addNewSubCategory(@PathVariable int pc_id,@RequestBody ProductSubCategory subcategory) {
		ProductCategory pcat=new ProductCategory();
		pcat.setPc_id(pc_id);
		subcategory.setProductCategory(pcat);
        pscService.addNewSubCategory(subcategory);
		return ResponseEntity.ok("New Sub-Category Added Successfully!!");
	}
	
	//cat_id not updating.... wrong arguments passing from postman
	@PutMapping("subcategories/update")
	public ResponseEntity<String> updateSubCategory(@RequestBody ProductSubCategory psCategory){
		pscService.updateSCategory(psCategory);
		return ResponseEntity.ok("Sub-Category updated successfully!!");
	}
	
	
	@DeleteMapping("subcategories/{psc_id}")
	public ResponseEntity<String> deleteSubCategory(@PathVariable int psc_id) {
        pscService.deleteCategory(psc_id);
		return ResponseEntity.ok("Selected Category Deleted Successfully!!");
	}
	
	

}
