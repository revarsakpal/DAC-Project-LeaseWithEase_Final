
package com.LeaseWithEaseBackend.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity; import
javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; import
javax.persistence.OneToMany; import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference; import
com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="customer", schema="leasewitheasedb")
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cust_id;
	@Column(unique=true)
    private String email_id;
	private String fname;
	private String lname;
	private String dob;
	private String role;
	private String password;
	private String phone_no;
	private String sign_up_date;
	@Embedded
	private Address address; 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    List<Order> orderList = new ArrayList<>();

	public Customer() { 
		super();
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getSign_up_date() {
		return sign_up_date;
	}

	public void setSign_up_date(String sign_up_date) {
		this.sign_up_date = sign_up_date;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	
	
}

