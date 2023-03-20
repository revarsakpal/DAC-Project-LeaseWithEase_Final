package com.LeaseWithEaseBackend.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="transporter", schema="leasewitheasedb")
public class Transporter{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int tr_id;
	private String email_id;
	private String fname;
	private String lname;
	private String password;
	private String phone_no;
	private String sign_up_date;
	private String terminate_date;
	@Embedded
	private Address addr;
	//private String address;
	private double rate_of_del;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "transporter")
    List<Order> orderList = new ArrayList<>();
	public Transporter() {
		super();
	}
	
	public int getTr_id() {
		return tr_id;
	}

	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
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
	
	public double getRate_of_del() {
		return rate_of_del;
	}
	public void setRate_of_del(double rate_of_del) {
		this.rate_of_del = rate_of_del;
	}
	public String getTerminate_date() {
		return terminate_date;
	}
	public void setTerminate_date(String terminate_date) {
		this.terminate_date = terminate_date;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	

}
