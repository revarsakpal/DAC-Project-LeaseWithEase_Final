package com.LeaseWithEaseBackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LeaseWithEaseBackend.Model.ProductCategory;
import com.LeaseWithEaseBackend.Service.ProductCategoryService;
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductCategoryController {
	@Autowired
	ProductCategoryService pcService;
	@GetMapping("categories")
	public List<ProductCategory> getAllPCategory() {
		List<ProductCategory> pcList=pcService.getAllCategory();
		return pcList;
	}
	@GetMapping("categories/{pc_id}")
	public ProductCategory getCategoryById(@PathVariable int pc_id) {
		ProductCategory pcat=pcService.getCategoryById(pc_id);
		return pcat;
	}

	@PostMapping("categories/addNew")
	public ResponseEntity<String> addNewCategory(@RequestBody ProductCategory category) {
        pcService.addNewCategory(category);
		return ResponseEntity.ok("New Category Added Successfully!!");
	}
	
	@DeleteMapping("categories/{pc_id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int pc_id) {
        pcService.deleteCtaegory(pc_id);
		return ResponseEntity.ok("Selected Category Deleted Successfully!!");
	}
	
	

}
