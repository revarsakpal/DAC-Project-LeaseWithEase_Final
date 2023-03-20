package com.LeaseWithEaseBackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LeaseWithEaseBackend.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	/*
	 * @Query("SELECT products FROM Product product where products.productCategory in :pc_id and products.subCategory in:psc_id"
	 * ) List<Product> findAllProductByCategory(int pc_id,int psc_id);
	 */
	
}
