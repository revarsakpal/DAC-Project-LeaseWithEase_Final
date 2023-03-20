package com.LeaseWithEaseBackend.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lineitem")
public class LineItem {
@Id
private int line_id;
private int qty;
private double dep_amount;
private String dep_amt_rec_date;
private String dep_amt_ret_date;
private String order_date;
private String rented_upto;
private int emiCount;
@ManyToOne
Order order;
@ManyToOne
Product product;
@OneToMany(mappedBy="lineItem")
List<Rent> rent;
public LineItem() {
	super();
}
public int getLine_id() {
	return line_id;
}
public void setLine_id(int line_id) {
	this.line_id = line_id;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public double getDep_amount() {
	return dep_amount;
}
public void setDep_amount(double dep_amount) {
	this.dep_amount = dep_amount;
}
public String getDep_amt_rec_date() {
	return dep_amt_rec_date;
}
public void setDep_amt_rec_date(String dep_amt_rec_date) {
	this.dep_amt_rec_date = dep_amt_rec_date;
}
public String getDep_amt_ret_date() {
	return dep_amt_ret_date;
}
public void setDep_amt_ret_date(String dep_amt_ret_date) {
	this.dep_amt_ret_date = dep_amt_ret_date;
}
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public String getRented_upto() {
	return rented_upto;
}
public void setRented_upto(String rented_upto) {
	this.rented_upto = rented_upto;
}
public int getEmiCount() {
	return emiCount;
}
public void setEmiCount(int emiCount) {
	this.emiCount = emiCount;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public List<Rent> getRent() {
	return rent;
}
public void setRent(List<Rent> rent) {
	this.rent = rent;
}






}
