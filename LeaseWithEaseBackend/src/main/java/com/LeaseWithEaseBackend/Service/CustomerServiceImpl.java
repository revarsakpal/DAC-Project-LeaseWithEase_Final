package com.LeaseWithEaseBackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LeaseWithEaseBackend.Model.Customer;
import com.LeaseWithEaseBackend.Model.Transporter;
import com.LeaseWithEaseBackend.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerReposository;


	@Override
	public List<Customer> getAllCustomer() {
		return customerReposository.findAll();
	}

	@Override
	public Customer getCustomerById(int cust_id) {
		Optional<Customer> op= customerReposository.findById(cust_id);
		return op.get();
	}

	@Override
	public void addNewT(Customer cust) {
		customerReposository.save(cust);	
	}

	@Override
	public void deleteCustomer(int cust_id) {
		customerReposository.deleteById(cust_id);
	}

	@Override
	public void updateCustomer(Customer cust) {
		Optional<Customer> op=customerReposository.findById(cust.getCust_id());
		Customer existingCust=op.get();
		existingCust.setFname(cust.getFname());
		existingCust.setLname(cust.getLname());
		existingCust.setEmail_id(cust.getEmail_id());
		existingCust.setPhone_no(cust.getPhone_no());
		existingCust.setDob(cust.getDob());
		existingCust.setRole("Customer");
		existingCust.setDob(cust.getDob());
		existingCust.setAddress(cust.getAddress());
	}

	@Override
	public String changePassword(String email_id, String oldPassword, String newPassword) {
		Customer c=getByEmail(email_id);
			if(c!=null) {
				
				if(c.getPassword().equals(oldPassword)) {
					c.setPassword(newPassword);
					customerReposository.save(c);
					return "Password changed Successfully!!";
				}
				return "Old Password does not match!!";
				}
				return "Account with this email id is not present!!";
	}

	@Override
	public Customer getByEmail(String email_id) {

		List<Customer> custList= customerReposository.findAll();
		for(Customer c : custList) {
			if(c.getEmail_id().equals(email_id))
				return c;
		}
		return null;
		}

	@Override
	public boolean authenticateCustomer(String email_id, String password) {
		Customer t=getByEmailId(email_id);
         if(t.getPassword().equals(password))
          return true;
		return false;
	}

	private Customer getByEmailId(String email_id) {
		List<Customer> cList=customerReposository.findAll();
         for(Customer c : cList) {
        	 if(c.getEmail_id().equals(email_id))
        		 return c;
         }
		return null;
	}
	}

