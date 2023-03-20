package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(int p_id);

	void addNewProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int p_id);

	List<Product> getAllSubcaterisedProducts(int pc_id, int psc_id);

}
