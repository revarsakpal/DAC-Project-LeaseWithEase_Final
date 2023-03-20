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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int p_id;
	 @Column(name="prod_name")
	    private String prod_name;
	    private String prod_desc;
	    private String prod_img_url;
	    private int stock;
	    private double unit_price;

	    @ManyToOne          
	    @JoinColumn(name = "pc_id")
	   // @JsonIgnoreProperties({ "subCategories" })
	    private ProductCategory productCategory;

	    @ManyToOne
	   // @JsonIgnoreProperties(value = { "subCategory"})
	    @JoinColumn(name = "psc_id")
	    private ProductSubCategory subCategory;

		public Product() {
			super();
		}

		public int getP_id() {
			return p_id;
		}

		public void setP_id(int p_id) {
			this.p_id = p_id;
		}

		

		public String getProd_name() {
			return prod_name;
		}

		public void setProd_name(String prod_name) {
			this.prod_name = prod_name;
		}

		public String getProd_desc() {
			return prod_desc;
		}

		public void setProd_desc(String prod_desc) {
			this.prod_desc = prod_desc;
		}

		public String getProd_img_url() {
			return prod_img_url;
		}

		public void setProd_img_url(String prod_img_url) {
			this.prod_img_url = prod_img_url;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public double getUnit_price() {
			return unit_price;
		}

		public void setUnit_price(double unit_price) {
			this.unit_price = unit_price;
		}

		public ProductCategory getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(ProductCategory productCategory) {
			this.productCategory = productCategory;
		}

		public ProductSubCategory getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(ProductSubCategory subCategory) {
			this.subCategory = subCategory;
		}
	    
	    
	    
	    
}
