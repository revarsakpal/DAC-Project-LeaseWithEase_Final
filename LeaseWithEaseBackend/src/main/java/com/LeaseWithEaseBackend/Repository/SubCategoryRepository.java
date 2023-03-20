package com.LeaseWithEaseBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeaseWithEaseBackend.Model.ProductSubCategory;

public interface SubCategoryRepository extends JpaRepository<ProductSubCategory, Integer> {

}
