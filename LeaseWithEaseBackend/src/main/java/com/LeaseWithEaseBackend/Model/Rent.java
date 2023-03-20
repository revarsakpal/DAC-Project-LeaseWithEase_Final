package com.LeaseWithEaseBackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Rent_Details")
public class Rent {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int rent_id;
private int emi_no;
private int emi_rec_date;
@OneToOne
private LineItem lineItem;
public Rent() {
	super();
}
public int getRent_id() {
	return rent_id;
}
public void setRent_id(int rent_id) {
	this.rent_id = rent_id;
}
public int getEmi_no() {
	return emi_no;
}
public void setEmi_no(int emi_no) {
	this.emi_no = emi_no;
}
public int getEmi_rec_date() {
	return emi_rec_date;
}
public void setEmi_rec_date(int emi_rec_date) {
	this.emi_rec_date = emi_rec_date;
}
public LineItem getLineItem() {
	return lineItem;
}
public void setLineItem(LineItem lineItem) {
	this.lineItem = lineItem;
}



}
