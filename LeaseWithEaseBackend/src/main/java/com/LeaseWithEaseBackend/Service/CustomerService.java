package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();

	Customer getCustomerById(int cust_id);

	void addNewT(Customer cust);

	void deleteCustomer(int cust_id);

	void updateCustomer(Customer cust);

	String changePassword(String email_id, String oldPassword, String newPassword);

	Customer getByEmail(String email_id);

	boolean authenticateCustomer(String email_id, String password);

}
