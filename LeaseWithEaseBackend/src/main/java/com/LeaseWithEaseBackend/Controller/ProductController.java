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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Model.Product;
import com.LeaseWithEaseBackend.Model.ProductCategory;
import com.LeaseWithEaseBackend.Model.ProductSubCategory;
import com.LeaseWithEaseBackend.Service.ProductService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService pService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> pList=pService.getAllProducts();
		return ResponseEntity.ok(pList);
	}

	@GetMapping("/products/{p_id}")
	public ResponseEntity<Product> getProductById(@PathVariable int p_id){
		Product product=pService.getProductById(p_id);
		return ResponseEntity.ok(product);
	}

	@PostMapping("/products/addNew")
	public ResponseEntity<String> addNewProduct(@RequestBody Product product,@RequestParam int pc_id,@RequestParam int psc_id){
		ProductSubCategory psc=new ProductSubCategory();
		psc.setPsc_id(psc_id);
		ProductCategory pc=new ProductCategory();
		pc.setPc_id(pc_id);
		product.setProductCategory(pc);
		product.setSubCategory(psc);
		System.out.println(product.getProd_name());
		pService.addNewProduct(product);
		return ResponseEntity.ok("Product Added Successfully!!");
	}

	@PutMapping("/products/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product updatedproduct,@RequestParam int pc_id,@RequestParam int psc_id){
		ProductSubCategory psc=new ProductSubCategory();
		psc.setPsc_id(psc_id);
		ProductCategory pc=new ProductCategory();
		pc.setPc_id(pc_id);
		updatedproduct.setProductCategory(pc);
		updatedproduct.setSubCategory(psc);
		pService.updateProduct(updatedproduct);
		return ResponseEntity.ok("Product details updated Successfully!!");
	}

	@DeleteMapping("/products/delete/{p_id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int p_id){
		pService.deleteProduct(p_id);
		return ResponseEntity.ok("Product Deleted Successfully!!");
	}
	
	@GetMapping("products/category")
	public ResponseEntity<List<Product>> getCategorywiseProducts(@RequestParam int pc_id,@RequestParam int psc_id){
		List<Product> productList=pService.getAllSubcaterisedProducts(pc_id,psc_id);
		return ResponseEntity.ok(productList);
	}
	
}
