package com.LeaseWithEaseBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ProductSubCategory")
public class ProductSubCategory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psc_id;

    @Column
    private String subCategoryName;
    
    @Column
    private String img_url;
    
    @ManyToOne(fetch = FetchType.EAGER)     //multiple subcategories can have one category
    @JsonBackReference
    @JoinColumn(name = "pc_id")
    private ProductCategory productCategory;

	public ProductSubCategory() {
		super();
	}

	public int getPsc_id() {
		return psc_id;
	}

	public void setPsc_id(int psc_id) {
		this.psc_id = psc_id;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	

}
